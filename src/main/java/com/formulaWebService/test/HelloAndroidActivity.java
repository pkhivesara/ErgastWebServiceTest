package com.formulaWebService.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "FormaulWebServiceTest";
    Button button1;
    TextView textView;
    String date;
    String venue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        button1 = (Button) findViewById(R.id.button1);
        textView = (TextView) findViewById(R.id.textView1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCallToErgastWebService();
            }
        });


    }

    private void makeCallToErgastWebService() {
        ApiResponse mrData = RestClient.get().getResult("3");
       // List<RaceTable.Races> races = mrData.mrdata.raceTable.races;
        //venue = races.get(0).raceName;
        //date = races.get(0).date;
        date = mrData.MRData.limit;
        venue = mrData.MRData.RaceTable.Races.get(0).raceName;
        textView.setText(date + venue);
    }

}

