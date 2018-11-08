package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Login extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Intent homeIntent = new Intent(this, Main2Activity.class);
        startActivity(homeIntent);
        finish();
    }

    public void registrar(View view) {

        Toast.makeText(this, "Not implemented...", Toast.LENGTH_SHORT).show();
    }
}
