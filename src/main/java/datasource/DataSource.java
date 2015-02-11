package datasource;


import pojo.ApiResponse;
import pojo.DriverDetails;

import java.util.List;

public interface DataSource {
    public void saveDriverDetails(DriverDetails driverDetails);

    public List<DriverModel> getDriverDetails();

    public DriverModel getDriverDetail(String id);

    public void saveRaceDetails(ApiResponse apiResponse);
}
