package com.formulaWebService.test;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DriverDetailsFragment extends Fragment implements FragmentsHelper.FragmentHelperInterface {

    FragmentsHelper fragmentsHelper;

    @InjectView(R.id.buttonDriverDetails)
    Button buttonDriverDetails;

    @InjectView(R.id.editTextSeason)
    EditText editTextSeason;

    @InjectView(R.id.listView)
    ListView listView;

    List<String> firstName = new ArrayList<String>();
    List<String> lastName = new ArrayList<String>();
    String tempFirstNameText;
    String tempLastNameText;

    @OnClick(R.id.buttonDriverDetails)
    void makeServiceCallForDrivers() {
        fragmentsHelper.makeCallToErgastWebService("driver", editTextSeason.getText().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_driver_details, container, false);
        fragmentsHelper = new FragmentsHelper(this);
        ButterKnife.inject(this, view);

        return view;

    }

    @Override
    public void setTextForDriverDetails(DriverDetails driverDetails) {


        for (int i = 0; i < driverDetails.MRData.DriverTable.Drivers.size(); i++) {
            tempFirstNameText = driverDetails.MRData.DriverTable.Drivers.get(i).givenName;
            tempLastNameText = driverDetails.MRData.DriverTable.Drivers.get(i).familyName;
            firstName.add(tempFirstNameText);
            lastName.add(tempLastNameText);

        }
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(firstName, lastName);
        listView.setAdapter(customBaseAdapter);


    }

    @Override
    public void setTextForRaceDetails(String date, String venue) {

    }

    private class CustomBaseAdapter extends BaseAdapter {
        List<String> firstName;
        List<String> lastName;

        public CustomBaseAdapter(List<String> firstName, List<String> lastName) {
            this.firstName = firstName;
            this.lastName = lastName;


        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return firstName.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
                viewHolder = new ViewHolder();

                viewHolder.firstName = (TextView) convertView.findViewById(android.R.id.text1);
                viewHolder.lastName = (TextView) convertView.findViewById(android.R.id.text2);

                convertView.setTag(viewHolder);

            } else {
                viewHolder = (ViewHolder) convertView.getTag();

            }

            viewHolder.firstName.setText(firstName.get(position));
            viewHolder.lastName.setText(lastName.get(position));

            return convertView;
        }

        private class ViewHolder {
            TextView firstName;
            TextView lastName;
        }
    }
}

