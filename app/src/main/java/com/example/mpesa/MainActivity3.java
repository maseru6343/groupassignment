package com.example.mpesa;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

public class MainActivity3 extends AppCompatActivity {

    //ActivityMainBinding binding;
    String Names, Village,Age;
    FirebaseDatabase database;
    DatabaseReference mreference;
    FirebaseAuth mAuth;


    public static final String EXTRA_TEXT="com.Mpesa.application.Mpesa.EXTRA_TEXT";
    public static final String EXTRA_NUMBER= "com.Mpesa.application.Mpesa.EXTRA_NUMBER";
    Button button;
    EditText user_name,p_number,p_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        user_name=findViewById(R.id.Names);
        p_number=findViewById(R.id.Village);
        p_code=findViewById(R.id.Age);
        button=(Button)findViewById(R.id.but);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernames = user_name.getText().toString().trim();
                String phonenumber = p_number.getText().toString().trim();
                String pincode = p_code.getText().toString().trim();

                if (usernames.isEmpty()) {
                    user_name.setError("Enter your full names");
                    user_name.requestFocus();
                    return;

                    /*ab Retha = new ab(Names,Village,Age);
                    database = FirebaseDatabase.getInstance();
                    reference = DatabaseReference.getReference("retha");

                    reference.child(Names).setValue(Retha).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {


                            Toast.makeText(MainActivity3.this, "Successfully Sent",Toast.LENGTH_SHORT).show();
                        }
                    });*/

}
                if (phonenumber.isEmpty()) {
                    p_number.setError("Enter your phone number");
                    p_number.requestFocus();
                    return;
                }
                if (pincode.isEmpty()) {
                    p_code.setError("Enter your full names");
                    p_code.requestFocus();
                    return;
                }
                if (pincode.length()  > 4)
                {p_code.setError("invalid pin.The is 4 digits or above");
                    return;
                }
                if (phonenumber.length() > 9 && phonenumber.length() > 7) {
                    p_number.setError("your phone number should be 8 digits long and valid");
                    p_number.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(usernames = user_name.getText().toString(),pincode = p_code.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity3.this, "You are successfully Registered", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity3.this, "You are not registered", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }

            });
    }
    }
