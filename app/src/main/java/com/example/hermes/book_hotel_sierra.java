package com.example.hermes;

import static com.example.hermes.login.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class book_hotel_sierra extends AppCompatActivity {

    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    ImageView openMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_hotel_sierra);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1 = findViewById(R.id.hot4);
        t2 = findViewById(R.id.hot6);
        t3 = findViewById(R.id.hot8);
        t4 = findViewById(R.id.hot2);
        openMenu=findViewById(R.id.profile);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent book = new Intent(Intent.ACTION_VIEW);
                book.setData(Uri.parse("https://www.mammothmountain.com/plan-your-trip/mammoth-hotels/mammoth-mountain-inn"));
                startActivity(book);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent book = new Intent(Intent.ACTION_VIEW);
                book.setData(Uri.parse("https://www.google.com/travel/hotels/Nevada%2C%20USA/entity/CgoI17Tnx9jZz9A3EAE?q=hard%20rock%20hotel%20nevada&g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4570333%2C4597339%2C4757164%2C4814050%2C4850738%2C4861688%2C4864715%2C4874190%2C4886480%2C4893075%2C4920132%2C4924070%2C4936396%2C4965990%2C4967051%2C4968087%2C4972345%2C4977394%2C4977499%2C4983186%2C4989886&hl=en-IN&gl=in&cs=1&ssta=1&ts=CAESABogCgIaABIaEhQKBwjnDxAEGAMSBwjnDxAEGAQYATICEAAqCQoFOgNJTlIaAA&rp=ENe058fY2c_QNxCMyP35n4KwmJ0BOAJAAUgDogELTmV2YWRhLCBVU0HAAQOaAgIIAA&ap=aAE&ictx=1&sa=X&ved=0CAAQ5JsGahcKEwiw1Y2Nu4T-AhUAAAAAHQAAAAAQBA&utm_campaign=sharing&utm_medium=link&utm_source=htls"));
                startActivity(book);
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent book = new Intent(Intent.ACTION_VIEW);
                book.setData(Uri.parse("https://nakomaresort.com/"));
                startActivity(book);
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent book = new Intent(Intent.ACTION_VIEW);
                book.setData(Uri.parse("https://www.google.com/travel/hotels/sorensen's%20resort/entity/CgsI_oWksvPalMDAARAB/prices?q=sorensen%27s%20resort&g2lb=2502548%2C2503771%2C2503781%2C4258168%2C4270442%2C4284970%2C4291517%2C4306835%2C4570333%2C4597339%2C4757164%2C4814050%2C4850738%2C4861688%2C4864715%2C4874190%2C4886480%2C4893075%2C4920132%2C4924070%2C4936396%2C4965990%2C4967051%2C4968087%2C4972345%2C4977394%2C4977499%2C4983186%2C4989886&hl=en-IN&gl=in&cs=1&ssta=1&rp=EP6FpLLz2pTAwAEQ_oWksvPalMDAATgCQABIAcABAg&ictx=1&ved=0CAAQ5JsGahcKEwiY3pP6u4T-AhUAAAAAHQAAAAAQBA&utm_campaign=sharing&utm_medium=link&utm_source=htls&ts=CAESABpJCisSJzIlMHg4MDliYTcwODFhYjlmNjQxOjB4YzA4MDUyZDczNjQ5MDJmZRoAEhoSFAoHCOcPEAQYAxIHCOcPEAQYBBgBMgIQACoJCgU6A0lOUhoA"));
                startActivity(book);
            }
        });
        openMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(book_hotel_sierra.this,v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_pop,popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.logout:

                                SharedPreferences sharedPreferences= getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("name","");
                                editor.apply();
                                Toast.makeText(book_hotel_sierra.this, "Logged Out,Sign In Again To Continue ", Toast.LENGTH_SHORT).show();

                                Intent i= new Intent(getApplicationContext(),login.class);
                                startActivity(i);
                                finish();

                                return true;
                            case R.id.contact:
                                Toast.makeText(book_hotel_sierra.this, "www.hermes.com or hermeshelp@gmail.com ", Toast.LENGTH_SHORT).show();
                                return true;

                            case R.id.bh:
                                Toast.makeText(book_hotel_sierra.this, "To know Your Booking History Check Your registered Email ", Toast.LENGTH_LONG).show();
                                return true;


                            default:return false;
                        }


                    }
                });

                popupMenu.show();
            }
        });


    }
}