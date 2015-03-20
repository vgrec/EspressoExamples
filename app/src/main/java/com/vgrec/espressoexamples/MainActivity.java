package com.vgrec.espressoexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hold button ids with the corresponding Activities to launch, when a button is clicked
        Map<Integer, Class<? extends Activity>> actions = new HashMap<>();

        actions.put(R.id.type_text_button, EnterNameActivity.class);
        actions.put(R.id.spinner_selection_button, SpinnerSelectionActivity.class);
        actions.put(R.id.custom_list_adapter_button, CustomListActivity.class);
        actions.put(R.id.search_view_button, SearchViewActivity.class);
        actions.put(R.id.action_bar_button, ActionBarExampleActivity.class);

        setListeners(actions);
    }

    private void setListeners(Map<Integer, Class<? extends Activity>> actions) {
        for (final Map.Entry<Integer, Class<? extends Activity>> entry : actions.entrySet()) {
            findViewById(entry.getKey()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, entry.getValue());
                    startActivity(intent);
                }
            });
        }
    }
}
