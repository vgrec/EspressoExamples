package com.vgrec.espressosamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class CustomListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new BooksAdapter());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book = (Book) parent.getItemAtPosition(position);
                Intent intent = new Intent(CustomListActivity.this, BookDetailsActivity.class);
                intent.putExtra(BookDetailsActivity.TITLE, book.getTitle());
                intent.putExtra(BookDetailsActivity.AUTHOR, book.getAuthor());
                startActivity(intent);
            }
        });
    }

    /**
     * Adapter that provides views for the list
     */
    private class BooksAdapter extends BaseAdapter {

        /**
         * Some dummy items
         */
        private ArrayList<Book> items = new ArrayList<>(Arrays.asList(
                new Book(1, "Some book", "Robert Mulavski"),
                new Book(2, "Some book", "Robert Mulavski"),
                new Book(3, "Book 2", "Robert Mulavski"),
                new Book(4, "Alice in the", "Robert Mulavski"),
                new Book(5, "C++ for primers", "Robert Mulavski"),
                new Book(6, "What to do", "Robert Mulavski"),
                new Book(7, "How much", "Robert Mulavski"),
                new Book(8, "Why", "Robert Mulavski"),
                new Book(9, "Be cool", "Robert Mulavski"),
                new Book(10, "Anton", "Robert Mulavski"),
                new Book(11, "Alizar", "Robert Mulavski"),
                new Book(12, "How amazon", "Robert Mulavski"),
                new Book(13, "Aricie", "Robert Mulavski"),
                new Book(14, "Master Book", "Robert Mulavski"),
                new Book(15, "Nonavici", "Robert Mulavski"),
                new Book(16, "Roberto", "Robert Mulavski"),
                new Book(17, "Utilita", "Robert Mulavski")
        ));

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

            TextView bookTitle = (TextView) convertView.findViewById(R.id.book_title);
            bookTitle.setText(items.get(position).getTitle());

            TextView bookAuthor = (TextView) convertView.findViewById(R.id.book_author);
            bookAuthor.setText("by " + items.get(position).getAuthor());

            return convertView;
        }
    }

    /**
     * The model class used in this activity
     */
    private class Book {
        private int id;
        private String title;
        private String author;

        private Book(int id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getId() {
            return id;
        }
    }
}
