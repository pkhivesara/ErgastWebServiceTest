package com.formulaWebService.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import retrofit.RestClient;

public class MainActivity extends Activity {


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

    }

    private void makeCallToErgastWebService(String typeOfCall) {

        if (typeOfCall.equals("race")) {
            ApiResponse mrData = RestClient.get().getRoundDetail(editTextRound.getText().toString());
            date = mrData.MRData.RaceTable.Races.get(0).date;
            venue = mrData.MRData.RaceTable.Races.get(0).raceName;
            textViewResponse.setText(date + venue);
        } else {
            DriverDetails driverDetails = RestClient.get().getDriverDetails(editTextSeason.getText().toString(), "25");
            date = driverDetails.MRData.DriverTable.Drivers.get(0).givenName;
            venue = driverDetails.MRData.DriverTable.Drivers.get(10).givenName;
            textViewResponse.setText(date + venue);
        }
    }

}

