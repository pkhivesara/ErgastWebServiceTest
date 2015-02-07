package pojo;


import java.util.List;

public class DriverDetails {
   public MRData MRData;

    public class MRData {
        String xmlns;
        String series;
        String url;
        String limit;
        String offset;
        String total;
        public DriverTable DriverTable;

        public class DriverTable {
            public String season;
            public List<Drivers> Drivers;

            public class Drivers{
                public String driverId;
                public String permanentNumber;
                public String code;
                public String url;
                public String givenName;
                public String familyName;
                public String dateOfBirth;
                public String nationality;

            }
        }
    }
}
