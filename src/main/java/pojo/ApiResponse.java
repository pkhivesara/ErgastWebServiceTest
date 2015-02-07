package pojo;


public class ApiResponse {
    public MRData MRData;

    public class MRData {
        String xmlns;
        String series;
        String url;
        String limit;
        String offset;
        String total;
        public RaceTable RaceTable;
    }
}
