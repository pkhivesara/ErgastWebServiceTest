package com.formulaWebService.test;


import java.util.List;

public class RaceTable {
    String season;
    String round;
    List<Race> races;

    public class Race {
        String season;
        String round;
        String url;
        String raceName;
        Circuit circuit;
        String date;
        String time;

        public class Circuit {
            String circuitId;
            String url;
            String circuitName;
            Location location;

            public class Location {
                String lat;
                String locality;
                String country;
            }
        }
    }
}
