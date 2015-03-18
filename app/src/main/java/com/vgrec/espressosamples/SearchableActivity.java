package com.vgrec.espressosamples;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SearchableActivity extends ActionBarActivity {

    /**
     * A dummy collection of data where the user search term will be searched.
     */
    private String[] database = {
            "John Babovici",
            "Maria Huanes",
            "What to do",
            "If I told you",
            "Java",
            "Master mind",
            "Jorj"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setEmptyView(findViewById(R.id.empty_view));

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            List<String> results = search(query);
            listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results));
        }
    }

    private List<String> search(String query) {
        List<String> results = new ArrayList<>();

        for (String record : database) {
            if (record.toLowerCase().startsWith(query.toLowerCase())) {
                results.add(record);
            }
        }

        return results;
    }
}
