package datasource;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.query.Select;
import pojo.ApiResponse;
import pojo.DriverDetails;

import java.util.List;


public class PersistedDataSource implements DataSource {

    @Override
    public void saveDriverDetails(DriverDetails driverDetails) {
        ActiveAndroid.beginTransaction();
        for (int i = 0 ;i<driverDetails.MRData.DriverTable.Drivers.size();i++){
        DriverModel driverModel = new DriverModel(driverDetails.MRData.DriverTable.Drivers.get(i));
        driverModel.save();
        }
        ActiveAndroid.setTransactionSuccessful();
        ActiveAndroid.endTransaction();

    }

    @Override
    public List<DriverModel> getDriverDetails() {
        return new Select().from(DriverModel.class).execute();
    }

    @Override
    public DriverModel getDriverDetail(String id) {
        return new Select().from(DriverModel.class).where("id = ?", id).executeSingle();
    }

    @Override
    public void saveRaceDetails(ApiResponse apiResponse) {

    }
}
