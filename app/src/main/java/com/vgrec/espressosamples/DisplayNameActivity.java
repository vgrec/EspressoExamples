package com.vgrec.espressosamples;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import com.vgrec.R;


public class DisplayNameActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_name);

        String text = getIntent().getStringExtra(EnterNameActivity.NAME);
        TextView greetingTextView = (TextView) findViewById(R.id.greeting_message);
        greetingTextView.setText("Hello " + text + "!");
    }
}
