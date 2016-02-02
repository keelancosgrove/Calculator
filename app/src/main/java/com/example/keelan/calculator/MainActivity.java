package com.example.keelan.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.keelan.Calculator";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Checks if content in EditText is empty
    public boolean isEmpty(EditText editText){
        return (editText.getText().toString().trim().length()==0);
    }

    // Called when the user presses the add button
    public void addNumbers(View view){
        EditText firstString = (EditText) findViewById(R.id.first_number);
        EditText secondString = (EditText) findViewById(R.id.second_number);
        if (isEmpty(firstString) || isEmpty(secondString)){
            return;
        }
        int first_number = Integer.parseInt(firstString.getText().toString());
        int second_number= Integer.parseInt(secondString.getText().toString());
        TextView textView = (TextView) findViewById(R.id.displayresult);
        int result;
        switch (view.getId()) {
            case R.id.addButton: result = first_number+second_number;
                break;
            case R.id.subButton: result = first_number-second_number;
                break;
            case R.id.multButton: result = first_number*second_number;
                break;
            case R.id.divButton: result = first_number/second_number;
                break;
            default: result=0;
        }
        textView.setText(((Integer) result).toString());
    }
}
