package com.example.mpesa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class MainActivity4 extends AppCompatActivity {
    EditText pincode,phonenumber;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        pincode=findViewById(R.id.Names);
        phonenumber=findViewById(R.id.Village);
        Button btn_login = findViewById(R.id.login);
        Button btn_sign = findViewById(R.id.register);
        mAuth= FirebaseAuth.getInstance();
        btn_login.setOnClickListener(v -> {
            String email= phonenumber.getText().toString().trim();
            String password=pincode.getText().toString().trim();
            if(email.isEmpty())
            {
                phonenumber.setError("Email is empty");
                phonenumber.requestFocus();
                return;
            }

            if(password.isEmpty())
            {
                pincode.setError("Password is empty");
                pincode.requestFocus();
                return;
            }
            if(password.length()>5&&password.length()<3)
            {
                pincode.setError("Length of pincode is equal to four");
                pincode.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        startActivity(new Intent(MainActivity4.this, MainActivity5.class));
                    }
                    else {
                        Toast.makeText(MainActivity4.this,
                                "Please Check Your login Credentials",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            });
        });

        btn_sign.setOnClickListener(v -> startActivity(new Intent(MainActivity4.this,MainActivity3.class )));

    }

    public void login(View view) {
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }
}