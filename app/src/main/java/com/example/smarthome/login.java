package com.example.smarthome;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText etUsername,etPassword;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btSubmit = findViewById(R.id.bt_submit);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            login.this
                    );
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle("Login Success");
                    builder.setMessage("Welcome Admin");

                    builder.setNeutralButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(login.this, MainActivity.class));
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }else{
                    Toast.makeText(getApplicationContext(),"invalid user",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}