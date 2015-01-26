package com.formulaWebService.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RestClient;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity2 extends Activity {


    String date;
    String venue;

    private static String TAG = "FormulaOneWebServiceTest";

    @InjectView(R.id.buttonRaceDetails)
    Button buttonRaceDetails;

    @InjectView(R.id.textViewResponse)
    TextView textViewResponse;

    @InjectView(R.id.buttonDriverDetails)
    Button buttonDriverDetails;

    @InjectView(R.id.editTextRound)
    EditText editTextRound;

    @InjectView(R.id.editTextSeason)
    EditText editTextSeason;

    @OnClick(R.id.buttonRaceDetails)
    void makeServiceCallForRace() {
        makeCallToErgastWebService("race");
    }

    @OnClick(R.id.buttonDriverDetails)
    void makeServiceCallForDrivers() {
        makeCallToErgastWebService("driver");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        ButterKnife.inject(this);
        FragmentManager

    }

    private void makeCallToErgastWebService(String typeOfCall) {

        if (typeOfCall.equals("race")) {
            RestClient.get().getRoundDetail(editTextRound.getText().toString(), new Callback<ApiResponse>() {


                @Override
                public void success(ApiResponse apiResponse, Response response) {
                    date = apiResponse.MRData.RaceTable.Races.get(0).date;
                    venue = apiResponse.MRData.RaceTable.Races.get(0).raceName;
                    textViewResponse.setText(date + venue);
                }


                @Override
                public void failure(RetrofitError retrofitError) {
                    Toast.makeText(MainActivity2.this, "race call failed:" + retrofitError.getMessage(), Toast.LENGTH_LONG).show();
                }


            });
        } else if (typeOfCall.equals("driver")) {
            RestClient.get().getDriverDetails(editTextSeason.getText().toString(), "25", new Callback<DriverDetails>() {

                @Override
                public void success(DriverDetails driverDetails, Response response) {

                    date = driverDetails.MRData.DriverTable.Drivers.get(0).givenName;
                    venue = driverDetails.MRData.DriverTable.Drivers.get(10).givenName;
                    textViewResponse.setText(date + venue);
                }

                @Override
                public void failure(RetrofitError retrofitError) {
                    Toast.makeText(MainActivity2.this, "driver details call failed:" + retrofitError.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

