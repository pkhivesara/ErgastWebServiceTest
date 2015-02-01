package com.formulaWebService.test;


import android.app.*;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    ActionBar actionBar;
    ViewPager pager;
    RaceDetailsFragment raceDetailsFragment;
    DriverDetailsFragment driverDetailsFragment;

    String[] tabs = {RaceDetailsFragment.class.getName(), DriverDetailsFragment.class.getName()};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        actionBar = getActionBar();
        raceDetailsFragment = new RaceDetailsFragment();
        driverDetailsFragment = new DriverDetailsFragment();
        setUpActionBarTabs();


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
