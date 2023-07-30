package com.example.hermes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hermes.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.concurrent.TimeUnit;

public class otp extends AppCompatActivity {

    FirebaseAuth firebaseAuth= FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore= FirebaseFirestore.getInstance();


    EditText inputCode1, inputCode2, inputCode3, inputCode4, inputCode5, inputCode6;
    Button verify;
    String getBackendOTP;


    String firstName;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);

        verify = findViewById(R.id.signOtp);




        inputCode1 = findViewById(R.id.inputCode1);
        inputCode2 = findViewById(R.id.inputCode2);
        inputCode3 = findViewById(R.id.inputCode3);
        inputCode4 = findViewById(R.id.inputCode4);
        inputCode5 = findViewById(R.id.inputCode5);
        inputCode6=findViewById(R.id.inputCode6);






        getBackendOTP = getIntent().getStringExtra("backendOtp");
        firstName = getIntent().getStringExtra("firstName");


        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!inputCode1.getText().toString().trim().isEmpty() && !inputCode2.getText().toString().trim().isEmpty()
                        && !inputCode3.getText().toString().trim().isEmpty()
                        && !inputCode4.getText().toString().trim().isEmpty()
                        && !inputCode5.getText().toString().trim().isEmpty()
                        && !inputCode6.getText().toString().trim().isEmpty()) {
                    String getUserOtp = inputCode1.getText().toString() +
                            inputCode2.getText().toString() +
                            inputCode3.getText().toString() +
                            inputCode4.getText().toString() +
                            inputCode5.getText().toString() +
                            inputCode6.getText().toString();



                    if (getBackendOTP != null) {


                        verify.setVisibility(View.INVISIBLE);

                        PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getBackendOTP, getUserOtp);
                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {


                                        verify.setVisibility(View.VISIBLE);

                                        if (task.isSuccessful()) {


                                            Intent intent = new Intent(getApplicationContext(), login.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(otp.this, "Enter correct OTP", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });


                    } else {
                        Toast.makeText(otp.this, "Please check internet", Toast.LENGTH_SHORT).show();
                    }
                    //Toast.makeText(Otp.this, "Otp verified", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(otp.this, "Please fill all number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        moveNumToNext();



    }

    private void moveNumToNext() {

        inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    inputCode2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    inputCode3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    inputCode4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    inputCode5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputCode5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!charSequence.toString().trim().isEmpty()) {
                    inputCode6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }



}