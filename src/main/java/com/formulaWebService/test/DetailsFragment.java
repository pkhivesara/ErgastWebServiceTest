package com.formulaWebService.test;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.InjectView;


public class DetailsFragment extends Fragment {

    @InjectView(R.id.detailsFragmentTextView)


    TextView detailsFragmentTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        String details = getArguments().getString("DRIVER_DETAILS");
//        detailsFragmentTextView.setText(details);
        return inflater.inflate(R.layout.fragment_details, container, false);
    }
}
