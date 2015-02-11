package com.formulaWebService.test;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.ButterKnife;
import butterknife.InjectView;
import datasource.DriverModel;
import presenter.DriverDetailsFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class DriverDetailsFragment extends Fragment implements DriverDetailsFragmentPresenter.FragmentHelperInterface {

    DriverDetailsFragmentPresenter driverDetailsFragmentPresenter;

    @InjectView(R.id.listView)
    ListView listView;

    @InjectView(R.id.textViewResponse)
    TextView textView;

    List<String> firstName = new ArrayList<String>();
    List<String> lastName = new ArrayList<String>();
    String tempFirstNameText;
    String tempLastNameText;


    public void makeServiceCallForDrivers(String query) {
        driverDetailsFragmentPresenter.getDriverDetails(query);
    }

    @Override
    public void onResume() {
        driverDetailsFragmentPresenter.onResume();
        super.onResume();

    }

    @Override
    public void onPause() {
        driverDetailsFragmentPresenter.onPause();
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_driver_details, container, false);
        driverDetailsFragmentPresenter = new DriverDetailsFragmentPresenter(this);
        ButterKnife.inject(this, view);

        return view;

    }

    @Override
    public void setTextForDriverDetails(List<DriverModel> driverModels) {
        for (int i = 0; i < driverModels.size(); i++) {
            tempFirstNameText = driverModels.get(i).givenName;
            tempLastNameText = driverModels.get(i).familyName;
            firstName.add(tempFirstNameText);
            lastName.add(tempLastNameText);
        }
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(firstName, lastName);
        listView.setAdapter(customBaseAdapter);
        setUIElementsVisibilityAndClickListener();

    }



    private void setUIElementsVisibilityAndClickListener() {
        listView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String driverDetails = ((TextView)view.findViewById(android.R.id.text1)).getText().toString();
                Intent startDetailActivity = new Intent(getActivity(),DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("DRIVER_DETAILS",driverDetails);
                startDetailActivity.putExtras(bundle);
                startActivity(startDetailActivity);

            }
        });
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

