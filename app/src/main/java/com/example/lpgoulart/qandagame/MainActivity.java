package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
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

    public void letraA(View view) {
        final AlertDialog.Builder resposta = new AlertDialog.Builder(this);


        resposta.setTitle("Resposta Errada!!");
        resposta.setView(R.layout.fragment_resposta_errada);

        resposta.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent homeIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        resposta.show();
    }

    public void letraB(View view) {
        final AlertDialog.Builder resposta = new AlertDialog.Builder(this);


        resposta.setTitle("Resposta Certa!!");
        resposta.setView(R.layout.fragment_resposta_certa);

        resposta.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent homeIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        resposta.show();
    }

    public void letraC(View view) {
        final AlertDialog.Builder resposta = new AlertDialog.Builder(this);


        resposta.setTitle("Resposta Errada!!");
        resposta.setView(R.layout.fragment_resposta_errada);

        resposta.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent homeIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        resposta.show();
    }

    public void letraD(View view) {
        final AlertDialog.Builder resposta = new AlertDialog.Builder(this);


        resposta.setTitle("Resposta Errada!!");
        resposta.setView(R.layout.fragment_resposta_errada);

        resposta.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent homeIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(homeIntent);
                finish();
            }
        });
        resposta.show();
    }
}
