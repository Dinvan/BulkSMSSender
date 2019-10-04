/* Copyright (C) 2016 CodingInfinite Technologies - All Rights Reserved */

package com.info.bulksmssender;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    EditText limitEditText, pauseEditText;
    CheckBox checkBox;
    Button saveButton;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause_setting);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        TextView textView = findViewById(R.id.textView2);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "Powered by: " + "<a href='http://codinginfinite.com'>Coding Infinite</a>";
        textView.setText(Html.fromHtml(text));

        limitEditText = findViewById(R.id.editText);
        limitEditText.setText(String.valueOf(Integer.toString(MainActivity.pause)));

        pauseEditText = findViewById(R.id.editText2);
        pauseEditText.setText(String.valueOf(Integer.toString(MainActivity.limit)));

        saveButton = findViewById(R.id.button);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                finish();
                return true;

        }

        return true;
    }
}
