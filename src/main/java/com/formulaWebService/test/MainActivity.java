package com.formulaWebService.test;


import android.os.Bundle;
import android.support.v4.app.*;
import android.support.v4.view.ViewPager;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

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
