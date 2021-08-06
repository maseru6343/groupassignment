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

public class MainActivity7 extends AppCompatActivity {
    EditText amount,pnumber;
    FirebaseAuth mAuth;
    int balance = 100;
    int new_balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Intent intent = getIntent();
        pnumber=findViewById(R.id.Names);
        amount=findViewById(R.id.number);
        Button send = findViewById(R.id.send);
        //Button btn_sign = findViewById(R.id.register);
        mAuth= FirebaseAuth.getInstance();
        send.setOnClickListener(v -> {
            String email= pnumber.getText().toString().trim();
            String password=amount.getText().toString().trim();


            if(email.isEmpty())
            {
                pnumber.setError("Enter Receipient number");
                pnumber.requestFocus();
                return;
            }

            if(password.isEmpty())
            {
                amount.setError("Password is empty");
                amount.requestFocus();
                return;
            }
            /*if(password>balance)
            {
                amount.setError("Password is empty");
                amount.requestFocus();
                return;
            }*/
            if(pnumber.length()>9&&password.length()<8)
            {
                amount.setError("Length of phonenumber is equal to 8");
                amount.requestFocus();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                    if (task.isSuccessful()) {
                        startActivity(new Intent(MainActivity7.this, MainActivity6.class));
                    }
                    else {
                        Toast.makeText(MainActivity7.this,
                                "Transaction failed.Try Again",
                                Toast.LENGTH_SHORT).show();
                    }


                }

            });
        });



    }



    public void send(View view) {


    }

}