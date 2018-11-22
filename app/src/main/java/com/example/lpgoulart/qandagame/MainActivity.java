package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // volta pra pagina principal
    public void back(View view) {
        Intent homepage = new Intent(this, Main2Activity.class);
        startActivity(homepage);
        finish();
    }
}
