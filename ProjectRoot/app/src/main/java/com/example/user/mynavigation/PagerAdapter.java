package com.example.user.mynavigation;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    private Fragment[] fragments_array;

    public PagerAdapter(FragmentManager fm, int NumOfTabs, Fragment[] fragments_array) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.fragments_array = fragments_array;
    }

    @Override
    public Fragment getItem(int position) {
//
//        switch (position) {
//            case 0:
//                TabFragment1 tab1 = new TabFragment1();
//                return tab1;
//            case 1:
//                TabFragment2 tab2 = new TabFragment2();
//                return tab2;
//            case 2:
//                TabFragment3 tab3 = new TabFragment3();
//                return tab3;
//            default:
//                return null;
//        }
        return fragments_array[position];
    }

    @Override
    public int getCount() {
        //return mNumOfTabs;
        return fragments_array.length;
    }
}

