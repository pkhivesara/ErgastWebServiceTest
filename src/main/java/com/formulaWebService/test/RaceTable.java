package com.formulaWebService.test;


import java.util.List;

public class RaceTable {
    String season;
    String round;
    List<Races> Races;

    public class Races {
        String season;
        String round;
        String url;
        String raceName;
        Circuit Circuit;
        String date;
        String time;

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
