package com.formulaWebService.test;


import android.app.*;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.zip.Inflater;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    ActionBar actionBar;
    ViewPager pager;
    RaceDetailsFragment raceDetailsFragment;
    DriverDetailsFragment driverDetailsFragment;

    String[] tabs;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        submitTextFromSearchView(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        actionBar = getActionBar();
        raceDetailsFragment = new RaceDetailsFragment();
        driverDetailsFragment = new DriverDetailsFragment();
        tabs = new String[]{getString(R.string.circuit_details), getString(R.string.driver_details)};
        setUpActionBarTabs();
        setUpViewPagerListener();

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
                if(query.length() == 2 || query.length() == 1){
                raceDetailsFragment.makeServiceCallForRace(query);}
                else driverDetailsFragment.makeServiceCallForDrivers(query);
                return false;
            }
        });

    }

    private void setUpViewPagerListener() {
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
    }

    private void setUpActionBarTabs() {
        if (actionBar != null) {
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            for (String tempTabs : tabs) {
                actionBar.addTab(actionBar.newTab().setText(tempTabs).setTabListener(this));

            }
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return raceDetailsFragment;
                case 1:
                    return driverDetailsFragment;
            }
            return new Fragment();

        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
