package com.vgrec.espressoexamples;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


public class BookDetailsActivity extends ActionBarActivity {

    public static final String TITLE = "title";
    public static final String AUTHOR = "author";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        TextView bookTitle = (TextView) findViewById(R.id.book_title);
        TextView bookAuthor = (TextView) findViewById(R.id.book_author);

        bookTitle.setText(getIntent().getStringExtra(TITLE));
        bookAuthor.setText(getIntent().getStringExtra(AUTHOR));
    }
}
