package com.vgrec.espressoexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListener(R.id.type_text_button, EnterNameActivity.class);
        setListener(R.id.spinner_selection_button, SpinnerSelectionActivity.class);
        setListener(R.id.custom_list_adapter_button, CustomListActivity.class);
        setListener(R.id.search_view_button, SearchViewActivity.class);
        setListener(R.id.action_bar_button, ActionBarExampleActivity.class);
        setListener(R.id.viewpager_button, ViewPagerActivity.class);
    }

    private <T extends Activity> void setListener(int buttonResId, final Class<T> activity) {
        findViewById(buttonResId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, activity));
            }
        });
    }
}
