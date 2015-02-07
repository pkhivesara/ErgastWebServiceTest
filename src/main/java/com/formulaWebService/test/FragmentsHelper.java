package com.formulaWebService.test;

import pojo.ApiResponse;
import pojo.DriverDetails;
import retrofit.Callback;
import retrofit.RestClient;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class FragmentsHelper {

    FragmentHelperInterface helperInterface;
    public FragmentsHelper(FragmentHelperInterface helperInterface){
        this.helperInterface = helperInterface;
    }
     void makeCallToErgastWebService(String typeOfCall,String input) {

        if (typeOfCall.equals("race")) {
            RestClient.get().getRoundDetail(input, new Callback<ApiResponse>() {


                @Override
                public void success(ApiResponse apiResponse, Response response) {
                    String date = apiResponse.MRData.RaceTable.Races.get(0).date;
                    String venue = apiResponse.MRData.RaceTable.Races.get(0).raceName;
                    helperInterface.setTextForRaceDetails(date,venue);
                }


                @Override
                public void failure(RetrofitError retrofitError) {
                //    Toast.makeText(getActivity(), "race call failed:" + retrofitError.getMessage(), Toast.LENGTH_LONG).show();
                }


            });
        } else if (typeOfCall.equals("driver")) {
            RestClient.get().getDriverDetails(input, "25", new Callback<DriverDetails>() {

                @Override
                public void success(DriverDetails driverDetails, Response response) {
                    helperInterface.setTextForDriverDetails(driverDetails);
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                  //  Toast.makeText(getActivity(), "driver details call failed:" + retrofitError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }


    public interface FragmentHelperInterface{
        public void setTextForDriverDetails(DriverDetails driverDetails);

        public void setTextForRaceDetails(String date, String venue);
    }
}
