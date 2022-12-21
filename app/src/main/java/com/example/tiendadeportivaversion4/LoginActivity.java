package com.example.tiendadeportivaversion4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin, btnLoginRegister;
    private EditText editEmailLogin, editPassLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLoginRegister = (Button) findViewById(R.id.btnLoginRegister);
        editEmailLogin = (EditText) findViewById(R.id.editEmailLogin);
        editPassLogin = (EditText) findViewById(R.id.editPassLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editEmailLogin.getText().toString().matches("")
                        || editPassLogin.getText().toString().matches("")) {
                    Toast.makeText(LoginActivity.this, getString(R.string.texto_todos_los_campos_son_obligatorios), Toast.LENGTH_SHORT).show();
                } else {
                    String email = editEmailLogin.getText().toString();
                    String pass = editPassLogin.getText().toString();

                    FirebaseAuth mAuth;
                    // ...
                    // Initialize Firebase Auth
                    mAuth = FirebaseAuth.getInstance();

                    mAuth.signInWithEmailAndPassword(email, pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(getApplicationContext(), CatalogoActivity.class);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(LoginActivity.this, getString(R.string.text_contrasena_correo_incorrectos),
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });
                }
            }
        });

        btnLoginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}