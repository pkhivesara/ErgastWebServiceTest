package com.formulaWebService.test;

import android.app.Activity;
import android.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;


public class DetailsActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setBundleAndFragmentTransaction();


    }

    private void setBundleAndFragmentTransaction() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetailsFragment fragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("DRIVER_DETAILS", getIntent().getExtras().getString("DRIVER_DETAILS"));

        bundle.putInt("DRIVER_ID", getIntent().getExtras().getInt("DRIVER_ID"));
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.detailsActivity, fragment);
        fragmentTransaction.commit();
    }
}
