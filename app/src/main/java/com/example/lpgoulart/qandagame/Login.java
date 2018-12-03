package com.example.lpgoulart.qandagame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends Activity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            Toast.makeText(this, "Welcome back", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Login.this,Main2Activity.class));
            finish();
        }
    }


    public void login(View view) {
        final String email = ((TextView)findViewById(R.id.login_field)).getText().toString();
        final String password = ((TextView)findViewById(R.id.pass_field)).getText().toString();

        if (!email.isEmpty() && !password.isEmpty()) {
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Login.this, "Usuário logado com sucesso! ", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this,Main2Activity.class));
                                finish();
                            }else{
                                Toast.makeText(Login.this, "Erro ao entrar!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        else {
            Toast.makeText(Login.this, "Entrada invalida!", Toast.LENGTH_SHORT).show();
        }
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
                    Toast.makeText(Login.this, "Wait", Toast.LENGTH_SHORT).show();


                    mAuth.createUserWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Login.this, "Usuário cadastrado com Sucesso!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this,Main2Activity.class));
                                    finish();
                                }else{
                                    String resposta = task.getException().toString();
                                    Toast.makeText(Login.this, "Erro ao cadastrar Usuário!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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
