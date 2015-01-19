package com.formulaWebService.test;


import java.util.List;

public class DriverDetails {
    MRData MRData;

    public class MRData {
        String xmlns;
        String series;
        String url;
        String limit;
        String offset;
        String total;
        DriverTable DriverTable;

        public class DriverTable {
            String season;
            List<Drivers> Drivers;

            public class Drivers{
                String driverId;
                String permanentNumber;
                String code;
                String url;
                String givenName;
                String familyName;
                String dateOfBirth;
                String nationality;

            }
        }
    }
}
