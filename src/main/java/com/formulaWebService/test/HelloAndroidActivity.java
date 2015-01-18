package com.formulaWebService.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        textView = (TextView)findViewById(R.id.textView1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCallToErgastWebService();
            }
        });
        textView.setText(date + venue);

    }

    private void makeCallToErgastWebService() {
        ApiResponse apiResponse = RestClient.get().getResult("2");
        RaceTable.Races[] races = apiResponse.mrdata.raceTable.races;
        for(int i=0;i<races.length;i++){
             date = races[i].date;
             venue = races[i].raceName;
        }

    }

}

