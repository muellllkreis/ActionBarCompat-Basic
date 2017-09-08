/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.actionbarcompat.basic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean serviceStarted = false;
    // Add any fields you think you need up here.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_main);
        if(savedInstanceState != null) {
            serviceStarted = savedInstanceState.getBoolean("serviceStarted");
        }
        // You may need to add some lines here!
    }


    /**
     * This method creates the menu in the activity from the menu/main.xml file.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate our menu from the resources by using the menu inflater.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }


    /**
     * This method is called when one of the menu items to selected. These items
     * can be on the Action Bar, the overflow menu, or the standard options menu. You
     * should return true if you handle the selection.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                // Use this menu item to alternate starting and stopping the service
                if(!serviceStarted) {
                    Intent intent = new Intent(this, TimeDateService.class);
                    this.serviceStarted = true;
                    startService(intent);
                }
                else {
                    Intent intent = new Intent(this, TimeDateService.class);
                    this.serviceStarted = false;
                    stopService(intent);
                }
                return true;

            case R.id.menu_location:
                // Use this menu item to open a URL in a browser using an Intent
                EditText url = (EditText) findViewById(R.id.url);
                if((url.getText().toString().contains("http://") || url.getText().toString().contains("https://")
                    && url.getText().toString().contains("www."))) {
                    Uri uri = Uri.parse(url.getText().toString());
                    Intent openIntent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(openIntent);
                }
                else {
                    Toast.makeText(this, "Please enter a valid URL, starting with 'http' or 'https'", Toast.LENGTH_SHORT).show();
                }
                return true;

            case R.id.menu_settings:
                // Use this menu item to open another activity
                startCredentialsActivity();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("serviceStarted", this.serviceStarted);
    }

    public void startCredentialsActivity() {
        Intent startActivity = new Intent(this, SetCredentialsActivity.class);
        startActivityForResult(startActivity, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 0) {
            if(resultCode == RESULT_OK) {
                Snackbar.make(findViewById(android.R.id.content), "Username: " + data.getStringExtra("username").toString()
                                                                    + " First Name: " + data.getStringExtra("firstname").toString()
                                                                    + " Last Name: " + data.getStringExtra("lastname").toString()
                                                                    ,Snackbar.LENGTH_LONG).show();
            }
        }
    }

}
