package com.formulaWebService.test;


import android.app.*;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener{

    ActionBar actionBar;

    String [] tabs = {"First","Second"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for(String tempTabs : tabs){

            actionBar.addTab(actionBar.newTab().setText(tempTabs)
                    .setTabListener(this));

        }



        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {
                case 0:
                    return new RaceDetailsFragment();
                case 1:
                    return new DriverDetailsFragment();
            }
            return new Fragment();

        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
