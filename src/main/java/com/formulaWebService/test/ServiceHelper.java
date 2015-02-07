package com.formulaWebService.test;


import pojo.ApiResponse;
import pojo.DriverDetails;
import retrofit.Callback;
import retrofit.RestClient;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ServiceHelper {

    public void getRoundDetails(String input){
        RestClient.get().getRoundDetail(input, new Callback<ApiResponse>() {


            @Override
            public void success(ApiResponse apiResponse, Response response) {
                String date = apiResponse.MRData.RaceTable.Races.get(0).date;
                String venue = apiResponse.MRData.RaceTable.Races.get(0).raceName;
//                helperInterface.setTextForRaceDetails(date,venue); throw bus message here
            }


            @Override
            public void failure(RetrofitError retrofitError) {
                //    Toast.makeText(getActivity(), "race call failed:" + retrofitError.getMessage(), Toast.LENGTH_LONG).show();
            }


        });
    }

    public void getDriverDetails(String input){
        RestClient.get().getDriverDetails(input, "25", new Callback<DriverDetails>() {

            @Override
            public void success(DriverDetails driverDetails, Response response) {
             //   helperInterface.setTextForDriverDetails(driverDetails);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                //  Toast.makeText(getActivity(), "driver details call failed:" + retrofitError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
