package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SettingsUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);
    }

    // esse metodo muda o nome do usuario
    public void changeName(View view) {
        Toast.makeText(this, "Username updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // esse metodo muda a senha do usuario
    public void changePassword(View view) {
        Toast.makeText(this, "Password updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // esse metodo muda o nome e a senha do usuario
    public void changeAll(View view) {
        Toast.makeText(this, "Username and Password updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // volta pra pagina principal
    public void back(View view) {
        Intent homepage = new Intent(this, Main2Activity.class);
        startActivity(homepage);
        finish();
    }
}
