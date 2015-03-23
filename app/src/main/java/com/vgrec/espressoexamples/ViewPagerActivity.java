package com.vgrec.espressoexamples;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.astuetz.PagerSlidingTabStrip;


public class ViewPagerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private String[] tabs = {"New", "All"};

        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return newBooksFragment(position);
        }

        @Override
        public int getCount() {
            return tabs.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        private Fragment newBooksFragment(int position) {
            Bundle args = new Bundle();
            args.putInt("tab_index", position);
            BooksFragment fragment = new BooksFragment();
            fragment.setArguments(args);
            return fragment;
        }
    }

    public static class BooksFragment extends Fragment {
        private int currentTab;
        private static final int TAB_NEW = 0;
        private static final int TAB_ALL = 1;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            currentTab = getArguments().getInt("tab_index");
        }
    }
}
