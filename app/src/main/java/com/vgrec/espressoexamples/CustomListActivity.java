package com.vgrec.espressoexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.vgrec.espressoexamples.adapter.BooksAdapter;
import com.vgrec.espressoexamples.models.Book;


public class CustomListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(new BooksAdapter(this, Database.ALL_BOOKS));
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
}
