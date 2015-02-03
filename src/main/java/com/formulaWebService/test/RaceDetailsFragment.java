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
        setHasOptionsMenu(true);
        return view;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(getActivity(), "search icon clicked", Toast.LENGTH_LONG).show();

        }
        return true;
    }

    private void submitTextFromSearchView(Menu menu) {
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }

            @Override
            public boolean onQueryTextSubmit(String query) {
                makeServiceCallForRace(query);
                return false;
            }
        });

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        submitTextFromSearchView(menu);
        super.onCreateOptionsMenu(menu, inflater);
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



