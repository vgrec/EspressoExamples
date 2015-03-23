package com.vgrec.espressoexamples;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.vgrec.espressoexamples.adapter.BooksAdapter;
import com.vgrec.espressoexamples.models.Book;

import java.util.ArrayList;

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
        private static final int TAB_NEW = 0;
        private static final int TAB_ALL = 1;
        private ArrayList<Book> books = new ArrayList<>();
        private String headerText;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            int currentTab = getArguments().getInt("tab_index");
            if (currentTab == TAB_NEW) {
                books.addAll(Database.NEW_BOOKS);
                headerText = "NEW BOOKS";
            } else if (currentTab == TAB_ALL) {
                books.addAll(Database.ALL_BOOKS);
                headerText = "ALL BOOKS";
            }
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_books, container, false);
            ListView listView = (ListView) view.findViewById(R.id.list);
            listView.setAdapter(new BooksAdapter(getActivity(), books));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Book book = (Book) parent.getItemAtPosition(position);
                    Intent intent = new Intent(getActivity(), BookDetailsActivity.class);
                    intent.putExtra(BookDetailsActivity.TITLE, book.getTitle());
                    intent.putExtra(BookDetailsActivity.AUTHOR, book.getAuthor());
                    startActivity(intent);
                }
            });

            TextView headerTextView = (TextView) view.findViewById(R.id.header_text);
            headerTextView.setText(headerText);
            return view;
        }
    }
}
