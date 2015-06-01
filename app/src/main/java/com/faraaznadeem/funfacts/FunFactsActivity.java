package com.faraaznadeem.funfacts;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class FunFactsActivity extends ActionBarActivity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();

    private FactBook factbook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign them the Views from the layout file
        // final because it should not be able to update a different TextView
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout relLayout = (RelativeLayout) findViewById(R.id.relLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // change background color
                int color = mColorWheel.getColor();
                relLayout.setBackgroundColor(color);

                // get a new fact
                factLabel.setText(factbook.getFact());

                // set button text color to background
                showFactButton.setTextColor(color);
            }
        };
        showFactButton.setOnClickListener(listener);

        /*String message = "Yay! Our Activity was created!";
        Toast welcomeToast = Toast.makeText(this, message, Toast.LENGTH_LONG);
        welcomeToast.show();*/

        // One-liner Toast
        // Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_LONG).show();

        // add logs instead of Toasts to see what is happening in a better, verbose way
        // search for TAG to filter/get debug logs from logcat
        Log.d(TAG, "We're logging from the onCreate() method!");
    }
}
