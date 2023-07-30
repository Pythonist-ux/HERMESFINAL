package com.example.hermes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class otpVerify extends AppCompatActivity {

    EditText phoneno1;
    Button btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp_verify);

        btn = findViewById(R.id.genOtp);
        phoneno1 = findViewById(R.id.e1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneno = phoneno1.getText().toString().trim();

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + phoneno,
                        60,
                        TimeUnit.SECONDS,
                        otpVerify.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                                Intent intent = new Intent(getApplicationContext(), login.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(otpVerify.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }


                            @Override
                            public void onCodeSent(@NonNull String backendOTP, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                Intent i = new Intent(otpVerify.this, otp.class);
                                String p1 = phoneno1.getText().toString().trim();
                                i.putExtra("PhoneNumber", p1);
                                i.putExtra("backendOtp", backendOTP);
                                startActivity(i);
                            }
                        }
                );
            }
        });
    }
}