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

    public DriverModel() {
        super();
    }

    public DriverModel(DriverDetails.MRData.DriverTable.Drivers drivers) {
        this.driverId = drivers.driverId;
        this.permanentNumber = drivers.permanentNumber;
        this.code = drivers.code;
        this.url = drivers.url;
        this.givenName = drivers.givenName;
        this.familyName = drivers.familyName;
        this.dateOfBirth = drivers.dateOfBirth;
        this.nationality = drivers.nationality;


    }

}
