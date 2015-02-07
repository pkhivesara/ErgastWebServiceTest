package datasource;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import pojo.DriverDetails;

import java.util.List;


public class PersistedDataSource implements DataSource {
    @Override
    public void saveDriverDetails(DriverDetails driverDetails) {
        ActiveAndroid.beginTransaction();
        DriverModel driverModel = new DriverModel(driverDetails);
        driverModel.save();
        ActiveAndroid.endTransaction();

    }

    @Override
    public List<DriverModel> getDriverDetails(String season) {
        return new Select().from(DriverModel.class).where("season = ?", season).execute();
    }
}
