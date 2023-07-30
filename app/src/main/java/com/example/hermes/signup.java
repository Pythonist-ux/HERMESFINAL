package com.example.hermes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class signup extends AppCompatActivity {
    ImageView iv;
    Button bt;

    EditText email;
    EditText phone1;
    EditText pass1;
    EditText confirmpass;

    FirebaseAuth mAuth;
    FirebaseUser mUser;





    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.signup);

        iv = findViewById(R.id.back);
        bt = findViewById(R.id.signin);
        email = findViewById(R.id.email);
        phone1 = findViewById(R.id.number);
        pass1 = findViewById(R.id.password);
        confirmpass = findViewById(R.id.cpass);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        progressDialog = new ProgressDialog(this);






        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Auth();


            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(signup.this, login.class);

                startActivity(i);
            }
        });


    }

    private void Auth(){
        String e = email.getText().toString();
        String p = pass1.getText().toString();

        if (!e.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(e).matches()) {
            Toast.makeText(this, "Email Verified !", Toast.LENGTH_SHORT).show();
        }else if(p.isEmpty() || p.length()<4){
            pass1.setError("Enter Correct Password");
        }else {
            progressDialog.setMessage("Please Wait");
            progressDialog.setMessage("Please wait while we register your account...");

            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            Toast.makeText(this, "Enter valid Email address !", Toast.LENGTH_SHORT).show();
        }

        mAuth.createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    sendUserToNextActivity();
                    Toast.makeText(signup.this, "REGISTERED", Toast.LENGTH_SHORT).show();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(signup.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }

            private void sendUserToNextActivity() {
                Intent i = new Intent(signup.this,otpVerify.class);
                startActivity(i);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            }
        });
    }

}