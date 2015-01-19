package com.formulaWebService.test;


public class ApiResponse {
    MRData MRData;

    public class MRData {
        String xmlns;
        String series;
        String url;
        String limit;
        String offset;
        String total;
        RaceTable RaceTable;
    }
}
