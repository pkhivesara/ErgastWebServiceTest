package com.formulaWebService.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import butterknife.InjectView;
import butterknife.OnClick;

public class DriverDetailsFragment extends Fragment implements FragmentsHelper.FragmentHelperInterface {

    FragmentsHelper fragmentsHelper;
    @InjectView(R.id.buttonDriverDetails)
    Button buttonDriverDetails;

    @InjectView(R.id.editTextSeason)
    EditText editTextSeason;

    @OnClick(R.id.buttonDriverDetails)
    void makeServiceCallForDrivers() {
        fragmentsHelper.makeCallToErgastWebService("driver", editTextSeason.getText().toString());
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_driver_details,container,false);
         fragmentsHelper = new FragmentsHelper(this);


        return view;

    }

    @Override
    public void setTextForDriverDetails(String givenName, String givenName1) {

    }

    @Override
    public void setTextForRaceDetails(String date, String venue) {

    }
}
