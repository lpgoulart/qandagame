package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.widget.DrawerLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import org.w3c.dom.Text;

public class SettingsUser extends Activity{

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_user);

        auth = FirebaseAuth.getInstance();

        TextView useremail = (TextView) findViewById(R.id.emailUser);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        useremail.setText(user.getEmail());

    }

    // esse metodo muda o nome do usuario
    public void changeName(View view) {

            final AlertDialog.Builder usernameDialog = new AlertDialog.Builder(this);


            usernameDialog.setTitle("Username");
            usernameDialog.setView(R.layout.fragment_new_name);

            usernameDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent();
                    PendingIntent pendingIntent = PendingIntent.getActivity(SettingsUser.this, 0, intent, 0);
                    Notification notification = new Notification.Builder(SettingsUser.this)
                            .setTicker("Title")
                            .setContentTitle("Voce alterou o nome")
                            .setContentText("o nome foi alterado com sucesso")
                            .setSmallIcon(R.drawable.ic_action_done)
                            .setContentIntent(pendingIntent).getNotification();

                    notification.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0,notification);
                }
            });
            usernameDialog.show();

//        Toast.makeText(this, "Username updated (Notificação)", Toast.LENGTH_SHORT).show();
    }

    // esse metodo muda a senha do usuario
    public void changePassword(View view) {
            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            final AlertDialog.Builder passwordDialog = new AlertDialog.Builder(this);


        passwordDialog.setTitle("Password");
        passwordDialog.setView(R.layout.fragment_pass_confirmation);

            passwordDialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                    final String password = ((TextView)findViewById(R.id.pass_frag_input)).getText().toString();

                    Intent intent = new Intent();
                    PendingIntent pendingIntent = PendingIntent.getActivity(SettingsUser.this, 0, intent, 0);
                    Notification notification = new Notification.Builder(SettingsUser.this)
                            .setTicker("Title")
                            .setContentTitle("Voce alterou a senha")
                            .setContentText("a senha foi alterada com sucesso")
                            .setSmallIcon(R.drawable.ic_action_done_all)
                            .setContentIntent(pendingIntent).getNotification();

                    notification.flags = Notification.FLAG_AUTO_CANCEL;
                    NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                    nm.notify(0,notification);
                }
            });
        passwordDialog.show();



//        Toast.makeText(this, "Password updated (Notificação)", Toast.LENGTH_SHORT).show();
    }


    // volta pra pagina principal
    public void back(View view) {
        Intent homepage = new Intent(this, Main2Activity.class);
        startActivity(homepage);
        finish();
    }

}
