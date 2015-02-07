package pojo;


import java.util.List;

public class RaceTable {
    String season;
    String round;
    public List<Races> Races;

    public class Races {
        public String season;
        public String round;
        public String url;
        public String raceName;
        public Circuit Circuit;
        public String date;
        public String time;

        public class Circuit {
            String circuitId;
            String url;
            String circuitName;
            Location Location;

            public class Location {
                String lat;
                String locality;
                String country;
            }
        }
    }
}
