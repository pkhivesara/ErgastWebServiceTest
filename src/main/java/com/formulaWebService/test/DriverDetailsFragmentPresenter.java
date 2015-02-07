package com.formulaWebService.test;

import datasource.DataSource;
import pojo.ApiResponse;
import pojo.DriverDetails;
import retrofit.Callback;
import retrofit.RestClient;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class DriverDetailsFragmentPresenter {

    FragmentHelperInterface helperInterface;
    ServiceHelper serviceHelper;
    DataSource dataSource;
    public DriverDetailsFragmentPresenter(FragmentHelperInterface helperInterface){
        serviceHelper = new ServiceHelper(dataSource);
        this.helperInterface = helperInterface;
    }

    public void onResume(){

    }

    public void onPause(){

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
