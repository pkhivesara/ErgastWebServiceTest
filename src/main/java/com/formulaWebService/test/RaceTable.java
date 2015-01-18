package com.formulaWebService.test;


public class RaceTable {
    String season;
    String round;
    Races[] races;

    private class Races {
        String season;
        String round;
        String url;
        String raceName;
        Circuit circuit;
        String date;
        String time;

        private class Circuit {
            String circuitId;
            String url;
            String circuitName;
            Location location;

            private class Location {
                String lat;
                String locality;
                String country;
            }
        }
    }
}
