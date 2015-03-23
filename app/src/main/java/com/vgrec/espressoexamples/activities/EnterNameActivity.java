package com.vgrec.espressoexamples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vgrec.espressoexamples.R;


public class EnterNameActivity extends ActionBarActivity {

    public static final String NAME = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        final EditText nameEditText = (EditText) findViewById(R.id.name_edittext);
        final TextView errorTextView = (TextView) findViewById(R.id.error_text);

        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                if (name.length() > 0) {
                    errorTextView.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(EnterNameActivity.this, DisplayNameActivity.class);
                    intent.putExtra(NAME, name);
                    startActivity(intent);
                } else {
                    errorTextView.setVisibility(View.VISIBLE);
                }
            }
        });

    }

}
