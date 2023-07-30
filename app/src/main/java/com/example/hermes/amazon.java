package com.example.hermes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class amazon extends AppCompatActivity {
    ImageView back;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {z`
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amazon);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        back=findViewById(R.id.back);
        btn1=findViewById(R.id.book);
        btn2=findViewById(R.id.flight);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(amazon.this, homepage.class);
                startActivity(i);


                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }

        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(amazon.this, book_hotel_amazon.class);
                startActivity(i);


                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse("https://www.expedia.co.in/Flights-Search?flight-type=on&mode=search&trip=roundtrip&leg1=from%3AMumbai%2C+India+%28BOM-Chhatrapati+Shivaji+Intl.%29%2Cto%3AAmazon+Jungle%2Cdeparture%3A18%2F04%2F2023TANYT&options=cabinclass%3Aeconomy&leg2=from%3AAmazon+Jungle%2Cto%3AMumbai%2C+India+%28BOM-Chhatrapati+Shivaji+Intl.%29%2Cdeparture%3A19%2F04%2F2023TANYT&passengers=children%3A0%2Cadults%3A1%2Cseniors%3A0%2Cinfantinlap%3AY&fromDate=18%2F04%2F2023&toDate=19%2F04%2F2023&startDate=2023-04-18&endDate=2023-04-19"));
                startActivity(j);

            }
        });


    }
}