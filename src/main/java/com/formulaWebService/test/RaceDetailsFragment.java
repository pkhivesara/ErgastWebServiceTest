package com.formulaWebService.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import datasource.DriverModel;
import pojo.DriverDetails;
import presenter.RaceDetailsFragmentPresenter;

import java.util.List;

public class RaceDetailsFragment extends Fragment implements DriverDetailsFragmentPresenter.FragmentHelperInterface, RaceDetailsFragmentPresenter.RaceDetailsFragmentPresenterInterface {
    DriverDetailsFragmentPresenter fragmentsHelper;
    RaceDetailsFragmentPresenter raceDetailFragmentPresenter;

    @InjectView(R.id.textViewResponse)
    TextView textViewResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_race_details, container, false);
        fragmentsHelper = new DriverDetailsFragmentPresenter(this);
        raceDetailFragmentPresenter= new RaceDetailsFragmentPresenter(this);
        ButterKnife.inject(this, view);
        return view;

    }

    @Override
    public void setTextForDriverDetails(List<DriverModel> driverModels) {

    }


    public void makeServiceCallForRace(String query) {
        fragmentsHelper.getRoundDetails(query);
    }

    @Override
    public void setTextForRaceDetails(String date, String venue) {
        textViewResponse.setText(date + venue);
    }
}



