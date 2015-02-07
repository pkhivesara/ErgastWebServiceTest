package datasource;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import pojo.DriverDetails;

@Table(name = "drivers")
public class DriverModel extends Model {


    @Column(name = "season")
    public String season;

    @Column(name = "driver_id")
    public String driverId;

    @Column(name = "permanent_number")
    public String permanentNumber;

    @Column(name = "code")
    public String code;

    @Column(name = "url")
    public String url;

    @Column(name = "given_name")
    public String givenName;

    @Column(name = "family_name")
    public String familyName;

    @Column(name = "date_of_birth")
    public String dateOfBirth;

    @Column(name = "nationality")
    public String nationality;

    public DriverModel(){
        super();
    }
    public DriverModel(DriverDetails driverDetails) {
        this.season = driverDetails.MRData.DriverTable.season;

        for (int i = 0; i < driverDetails.MRData.DriverTable.Drivers.size(); i++) {
            this.driverId = driverDetails.MRData.DriverTable.Drivers.get(i).driverId;
            this.permanentNumber = driverDetails.MRData.DriverTable.Drivers.get(i).permanentNumber;
            this.code = driverDetails.MRData.DriverTable.Drivers.get(i).code;
            this.url = driverDetails.MRData.DriverTable.Drivers.get(i).url;
            this.givenName = driverDetails.MRData.DriverTable.Drivers.get(i).givenName;
            this.familyName = driverDetails.MRData.DriverTable.Drivers.get(i).familyName;
            this.dateOfBirth = driverDetails.MRData.DriverTable.Drivers.get(i).dateOfBirth;
            this.nationality = driverDetails.MRData.DriverTable.Drivers.get(i).nationality;

        }

    }

}
