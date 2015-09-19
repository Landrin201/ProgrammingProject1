package com.kuniansky.marc.unitconverter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Controls all of the actions from the main page of the app. All of this code
 * controls only button clicks and redirecting.
 *
 * Modifications:
 * 9/17/2015, Marc Kuniansky, Made a generalized method (onLengthButtonClick) which
 *                            can be used to redirect all of the buttons to the appropriate
 *                            activities when they are created. I will not update this comment
 *                            every time I add a new activity- it is a copy/paste/rename job.
 *
 */
public class SelectionActivity extends AppCompatActivity {
    /*Below are methods needed when the buttons on the main page of the app are clicked. */

    /**
     * Sends the user to the Length converter when the length button is pushed
     */
    public void onLengthButtonClick(View view)
    {
        Intent intent = new Intent(this, LengthActivity.class);
        startActivity(intent);
    }

    /**
     * Sends the user to the Area converter when the area button is clicked
     * @param view
     */
    public void onAreaButtonClick(View view)
    {
        Intent intent = new Intent(this, AreaConverter.class)
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection, menu);
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
}
