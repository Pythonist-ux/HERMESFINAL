package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class sierra extends AppCompatActivity {

    Button btn1, btn2;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sierra);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn1 = findViewById(R.id.book); // initialize btn1
        btn2 = findViewById(R.id.flight); // initialize btn2
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(sierra.this, homepage.class);
                startActivity(i);


                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(sierra.this, book_hotel_sierra.class);
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse("https://www.tripadvisor.in/Flights-g609099-Sierra_Nevada_Sierra_Nevada_National_Park_Province_of_Granada_Andalucia-Cheap_Discount_Airfares.html"));
                startActivity(j);
            }
        });

    }
}
