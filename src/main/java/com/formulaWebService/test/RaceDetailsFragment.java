package com.formulaWebService.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import datasource.DriverModel;
import datasource.RaceDetailModel;
import pojo.DriverDetails;
import presenter.RaceDetailsFragmentPresenter;

import java.util.List;

public class RaceDetailsFragment extends Fragment implements RaceDetailsFragmentPresenter.RaceDetailsFragmentPresenterInterface {
    RaceDetailsFragmentPresenter raceDetailFragmentPresenter;

    @InjectView(R.id.textViewResponse)
    TextView textViewResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_race_details, container, false);
        raceDetailFragmentPresenter= new RaceDetailsFragmentPresenter(this);
        ButterKnife.inject(this, view);
        return view;

    }

    public void makeServiceCallForRace(String query) {
        raceDetailFragmentPresenter.getRoundDetails(query);
    }


    @Override
    public void setTextForRaceDetails(RaceDetailModel raceDetailModel) {
        textViewResponse.setText(raceDetailModel.circuitName);
    }
}



