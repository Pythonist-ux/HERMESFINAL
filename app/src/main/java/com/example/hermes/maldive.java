package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class maldive extends AppCompatActivity {
    ImageView back,i1;
    Button btn1,btn2;
    boolean isImageFitToScreen;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.maldive);


        back=findViewById(R.id.back);
        btn1=findViewById(R.id.book);
        btn2=findViewById(R.id.flight);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(maldive.this, homepage.class);
                startActivity(i);


                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }

        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(maldive.this,book_hotel_maldive.class);
                startActivity(intent);




            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse("https://www.skyscanner.co.in/flights-to/mv/cheap-flights-to-maldives.html"));
                startActivity(j);

            }
        });
    }
}