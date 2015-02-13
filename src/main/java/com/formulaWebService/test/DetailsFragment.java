package com.formulaWebService.test;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import datasource.DataSource;
import datasource.DriverModel;
import datasource.PersistedDataSource;


public class DetailsFragment extends Fragment {

    @InjectView(R.id.detailsFragmentTextView)
    TextView detailsFragmentTextView;
    DataSource dataSource = new PersistedDataSource();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        int details = getArguments().getInt("DRIVER_ID");
        int driverId = details + 1;
        DriverModel driverModel = dataSource.getDriverDetail(Integer.toString(driverId));
        ButterKnife.inject(this, view);
        detailsFragmentTextView.setText(driverModel.dateOfBirth + driverModel.nationality);
        return view;
    }
}
