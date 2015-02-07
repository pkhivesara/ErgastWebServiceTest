package com.formulaWebService.test;

import pojo.ApiResponse;
import pojo.DriverDetails;
import retrofit.Callback;
import retrofit.RestClient;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class FragmentsHelper {

    FragmentHelperInterface helperInterface;
    ServiceHelper serviceHelper;
    public FragmentsHelper(FragmentHelperInterface helperInterface){
        serviceHelper = new ServiceHelper();
        this.helperInterface = helperInterface;
    }

    public void getRoundDetails(String input){
        serviceHelper.getRoundDetails(input);
    }

    public void getDriverDetails(String input){
        serviceHelper.getDriverDetails(input);

    }

    public interface FragmentHelperInterface{
        public void setTextForDriverDetails(DriverDetails driverDetails);

        public void setTextForRaceDetails(String date, String venue);
    }
}
