package com.formulaWebService.test;

import datasource.DataSource;
import datasource.DriverModel;
import datasource.PersistedDataSource;
import de.greenrobot.event.EventBus;
import pojo.ApiResponse;
import pojo.DriverDetails;
import retrofit.Callback;
import retrofit.RestClient;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.List;


public class DriverDetailsFragmentPresenter {

    FragmentHelperInterface helperInterface;
    ServiceHelper serviceHelper;
    DataSource dataSource = new PersistedDataSource();

    public DriverDetailsFragmentPresenter(FragmentHelperInterface helperInterface) {
        serviceHelper = new ServiceHelper(dataSource);
        this.helperInterface = helperInterface;
    }

    public void onResume() {
        EventBus.getDefault().register(this);
    }

    public void onPause() {
        EventBus.getDefault().unregister(this);
    }

    public void getRoundDetails(String input) {
        serviceHelper.getRoundDetails(input);
    }

    public void getDriverDetails(String input) {
        serviceHelper.getDriverDetails(input);

    }


    public void onEventMainThread(String message) {
        if (message.equals("data saved")) {
            List<DriverModel> driverModel = dataSource.getDriverDetails();
                helperInterface.setTextForDriverDetails(driverModel);
            }
        }


    public interface FragmentHelperInterface {
        public void setTextForDriverDetails(List<DriverModel> driverModels);

        public void setTextForRaceDetails(String date, String venue);
    }
}
