package datasource;


import pojo.DriverDetails;

import java.util.List;

public interface DataSource {
    public void saveDriverDetails(DriverDetails driverDetails);

    public List<DriverModel> getDriverDetails();
}
