package com.formulaWebService.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RaceDetailsFragment extends Fragment implements FragmentsHelper.FragmentHelperInterface {
    FragmentsHelper fragmentsHelper;

    @InjectView(R.id.buttonRaceDetails)
    Button buttonRaceDetails;

    @InjectView(R.id.textViewResponse)
    TextView textViewResponse;


    @InjectView(R.id.editTextRound)
    EditText editTextRound;


    @OnClick(R.id.buttonRaceDetails)
    void makeServiceCallForRace() {
        fragmentsHelper.makeCallToErgastWebService("race", editTextRound.getText().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_race_details, container, false);
        fragmentsHelper = new FragmentsHelper(this);
        ButterKnife.inject(this,view);
        return view;

    }



    @Override
    public void setTextForDriverDetails(DriverDetails driverDetails) {

    }

    @Override
    public void setTextForRaceDetails(String date, String venue) {
        textViewResponse.setText(date + venue);
    }
}



