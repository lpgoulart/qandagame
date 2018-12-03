package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.support.v4.widget.DrawerLayout;

public class SettingsUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);
    }

    // esse metodo muda o nome do usuario
    public void changeName(View view) {
        Intent intent = new Intent();
                    PendingIntent pendingIntent = PendingIntent.getActivity(SettingsUser.this, 0, intent, 0);
                    Notification notification = new Notification.Builder(SettingsUser.this)
                            .setTicker("Title")
                            .setContentTitle("Voce alterou o nome")
                            .setContentText("o nome foi alterado com sucesso")
                            .setSmallIcon(R.drawable.ic_drawer)
                            .setContentIntent(pendingIntent).getNotification();

                    notification.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0,notification);



//        Toast.makeText(this, "Username updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // esse metodo muda a senha do usuario
    public void changePassword(View view) {
        Intent intent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(SettingsUser.this, 0, intent, 0);
        Notification notification = new Notification.Builder(SettingsUser.this)
                .setTicker("Title")
                .setContentTitle("Voce alterou a senha")
                .setContentText("a senha foi alterada com sucesso")
                .setSmallIcon(R.drawable.ic_drawer)
                .setContentIntent(pendingIntent).getNotification();

        notification.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0,notification);
//        Toast.makeText(this, "Password updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // esse metodo muda o nome e a senha do usuario
    public void changeAll(View view) {
        Intent intent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(SettingsUser.this, 0, intent, 0);
        Notification notification = new Notification.Builder(SettingsUser.this)
                .setTicker("Title")
                .setContentTitle("Voce alterou o nome e a senha")
                .setContentText("Dados alterados com sucesso")
                .setSmallIcon(R.drawable.ic_drawer)
                .setContentIntent(pendingIntent).getNotification();

        notification.flags = Notification.FLAG_AUTO_CANCEL;
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(0,notification);
//        Toast.makeText(this, "Username and Password updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // volta pra pagina principal
    public void back(View view) {
        Intent homepage = new Intent(this, Main2Activity.class);
        startActivity(homepage);
        finish();
    }
}
