package datasource;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import pojo.RaceTable;

import java.util.List;
@Table(name = "races")
public class RaceDetailModel extends Model {


    @Column(name = "season")
    public String season;

    @Column(name = "round")
    public String round;

    @Column(name = "url")
    public String url;

    @Column(name = "race_name")
    public String raceName;

    @Column(name = "date")
    public String date;

    @Column(name = "time")
    public String time;

    @Column(name = "circuit_id")
    public String circuitId;

    @Column(name = "circuit_url")
    public String circuitUrl;


    @Column(name = "circuit_name")
    public String circuitName;


    @Column(name = "lat")
    public String lat;

    @Column(name = "locality")
    public String locality;

    @Column(name = "country")
    public String country;


    public RaceDetailModel(){
        super();
    }

    public RaceDetailModel(RaceTable.Races racesList){

    }
}
