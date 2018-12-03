package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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
        final String email = ((TextView)findViewById(R.id.login_field)).getText().toString();
        final String password = ((TextView)findViewById(R.id.pass_field)).getText().toString();

        if (!email.isEmpty() && !password.isEmpty()){
            final AlertDialog.Builder passwordDialog = new AlertDialog.Builder(this);

            passwordDialog.setTitle("Password");
            passwordDialog.setView(R.layout.fragment_pass_confirmation);

            passwordDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            passwordDialog.show();

        }else{
            AlertDialog.Builder wrongDataDialog = new AlertDialog.Builder(this);
            wrongDataDialog.setTitle("The field email and/or password can not be empty.");
            TextView message = new TextView(this);
            wrongDataDialog.setView(message);
            wrongDataDialog.setPositiveButton("Ok", null);
            wrongDataDialog.show();
        }
    }
}
