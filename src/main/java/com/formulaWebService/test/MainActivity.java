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
        if (savedInstanceState == null) {
          FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            RaceDetailsFragment fragment = new RaceDetailsFragment();
            fragmentTransaction.add(R.id.viewPager, fragment);
            fragmentTransaction.commit();
        }
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
    return new Fragment();

        }

        @Override
        public int getCount() {
            return 1;
        }
    }
}
