package com.formulaWebService.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "FormaulWebServiceTest";
    Button buttonRaceDetails;
    Button buttonDriverDetails;
    TextView textView;
    EditText editText;
    String date;
    String venue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        buttonRaceDetails = (Button) findViewById(R.id.buttonRaceDetails);
        buttonDriverDetails = (Button) findViewById(R.id.buttonDriverDetails);
        textView = (TextView) findViewById(R.id.textView1);
        editText = (EditText) findViewById(R.id.editText1);
        buttonRaceDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCallToErgastWebService("race");
            }
        });
        buttonDriverDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCallToErgastWebService("driver");
            }
        });


    }

    private void makeCallToErgastWebService(String typeOfCall) {

        if(typeOfCall.equals("race")){
        ApiResponse mrData = RestClient.get().getRoundDetail(editText.getText().toString());
        date = mrData.MRData.RaceTable.Races.get(0).date;
        venue = mrData.MRData.RaceTable.Races.get(0).raceName;
        textView.setText(date + venue);}
        else{
            DriverDetails driverDetails = RestClient.get().getDriverDetails("2012","25");
            date = driverDetails.MRData.DriverTable.Drivers.get(0).givenName;
            venue = driverDetails.MRData.DriverTable.Drivers.get(10).givenName;
            textView.setText(date + venue);
        }
    }

}

