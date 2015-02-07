package datasource;

import com.activeandroid.ActiveAndroid;
import pojo.DriverDetails;


public class PersistedDataSource implements DataSource {
    @Override
    public void saveDriverDetails(DriverDetails driverDetails) {
        ActiveAndroid.beginTransaction();
        DriverModel driverModel = new DriverModel(driverDetails);
        driverModel.save();
        ActiveAndroid.endTransaction();

    }
}
