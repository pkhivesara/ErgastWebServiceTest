package com.formulaWebService.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import android.widget.SearchView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class RaceDetailsFragment extends Fragment implements FragmentsHelper.FragmentHelperInterface {
    FragmentsHelper fragmentsHelper;

    @InjectView(R.id.textViewResponse)
    TextView textViewResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_race_details, container, false);
        fragmentsHelper = new FragmentsHelper(this);
        ButterKnife.inject(this, view);
        return view;

    }

    @Override
    public void setTextForDriverDetails(DriverDetails driverDetails) {

    }
    public void makeServiceCallForRace(String query) {
        fragmentsHelper.makeCallToErgastWebService("race", query);
    }

    @Override
    public void setTextForRaceDetails(String date, String venue) {
        textViewResponse.setText(date + venue);
    }
}



