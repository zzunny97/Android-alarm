package com.example.user.mynavigation;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    TabFragment1 fragment1;
    TabFragment2 fragment2;
    TabFragment3 fragment3;
    Fragment[] fragments_array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("알람보기"));
        tabLayout.addTab(tabLayout.newTab().setText("알람설정"));
        tabLayout.addTab(tabLayout.newTab().setText("통계"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        fragments_array = new Fragment[3];
        fragments_array[0] = new TabFragment1();
        fragments_array[1] = new TabFragment2();
        fragments_array[2] = new TabFragment3();
        fragment1 = (TabFragment1)fragments_array[0];
        fragment2 = (TabFragment2)fragments_array[1];
        fragment3 = (TabFragment3)fragments_array[2];

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), fragments_array);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //TabFragment1 fragment1 = new TabFragment1();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void addPlanItem(String planName, String time, String minute, boolean[] check_days) {
        Toast.makeText(this, "addPlanItem 함수", Toast.LENGTH_SHORT).show();
        Log.d("addPlanItem ", planName + time + minute);
        fragment1.addPlan(planName, time, minute, check_days);
    }


    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).
                return PlaceholderFragment.newInstance(position + 1);
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        //TabFragment1 tab1 = new TabFragment1();
                    case 1:
                        //TabFragment2 tab2 = new TabFragment2();
                    case 2:
                        //TabFragment3 tab3 = new TabFragment3();
                }
                return null;
            }
        }
    }

}

