package com.vgrec.espressosamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.vgrec.R;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setListenersFor(
                R.id.type_text_button,
                R.id.spinner_selection_button,
                R.id.custom_list_adapter_button,
                R.id.search_view_button,
                R.id.action_bar_button,
                R.id.viewpager_button,
                R.id.dialogs_button,
                R.id.recycler_view_button
        );
    }

    private void setListenersFor(int... buttonsResId) {
        for (int resId : buttonsResId) {
            findViewById(resId).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.type_text_button:
                openActivity(EnterNameActivity.class);
                break;
            case R.id.spinner_selection_button:
                openActivity(SpinnerSelectionActivity.class);
                break;
        }
    }

    private <T extends Activity> void openActivity(Class<T> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
