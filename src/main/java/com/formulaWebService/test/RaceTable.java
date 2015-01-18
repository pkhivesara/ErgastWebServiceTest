package com.formulaWebService.test;


public class RaceTable {
    String season;
    String round;
    Races[] races;

    public class Races {
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
