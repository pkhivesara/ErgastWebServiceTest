package com.formulaWebService.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DriverDetailsFragment extends Fragment implements FragmentsHelper.FragmentHelperInterface {

    FragmentsHelper fragmentsHelper;

    @InjectView(R.id.buttonDriverDetails)
    Button buttonDriverDetails;

    @InjectView(R.id.editTextSeason)
    EditText editTextSeason;

    @InjectView(R.id.listView)
    ListView listView;

    @OnClick(R.id.buttonDriverDetails)
    void makeServiceCallForDrivers() {
        fragmentsHelper.makeCallToErgastWebService("driver", editTextSeason.getText().toString());
        Toast.makeText(getActivity(),"CLICKED",Toast.LENGTH_LONG).show();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_driver_details,container,false);
         fragmentsHelper = new FragmentsHelper(this);
        ButterKnife.inject(this,view);

        return view;

    }

    @Override
    public void setTextForDriverDetails(DriverDetails driverDetails) {

    }

    @Override
    public void setTextForRaceDetails(String date, String venue) {

    }
}
