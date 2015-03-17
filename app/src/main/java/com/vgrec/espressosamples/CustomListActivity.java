package com.vgrec.espressosamples;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new BooksAdapter());
    }

    /**
     * Adapter that provides views for the list
     */
    private class BooksAdapter extends BaseAdapter {

        /**
         * Some dummy items
         */
        private ArrayList<Book> items = new ArrayList<Book>() {
            {
                add(new Book("Some book", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Book 2", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Alice in the", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("C++ for primers", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("What to do", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("How much", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Why", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Be cool", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Anton", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Alizar", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("How amazon", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Aricie", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Master Book", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Nonavici", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Roberto", "Robert Mulavski", R.mipmap.ic_launcher));
                add(new Book("Utilita", "Robert Mulavski", R.mipmap.ic_launcher));
            }
        };

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_book, parent, false);
            }

            TextView titleTextView = (TextView) convertView.findViewById(R.id.book_title);
            titleTextView.setText(items.get(position).getTitle());

            return convertView;
        }
    }

    /**
     * The model class used in this activity
     */
    private class Book {
        private String title;
        private String author;
        private int image;

        private Book(String title, String author, int image) {
            this.title = title;
            this.author = author;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getImage() {
            return image;
        }
    }
}
