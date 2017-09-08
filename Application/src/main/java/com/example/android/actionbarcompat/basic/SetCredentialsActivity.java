package com.example.android.actionbarcompat.basic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetCredentialsActivity extends AppCompatActivity {

    EditText username;
    EditText firstname;
    EditText lastname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_credentials);
        this.username = (EditText) findViewById(R.id.username);
        this.firstname = (EditText) findViewById(R.id.firstname);
        this.lastname = (EditText) findViewById(R.id.lastname);
    }

    public void setCredentials(View view) {
        Intent setIntent = new Intent(this, MainActivity.class);
        setIntent.putExtra("username", this.username.getText().toString());
        setIntent.putExtra("firstname", this.firstname.getText().toString());
        setIntent.putExtra("lastname", this.lastname.getText().toString());
        setResult(SetCredentialsActivity.RESULT_OK, setIntent);
        finish();
    }
}
