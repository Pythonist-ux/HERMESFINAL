package com.example.hermes;

import static com.example.hermes.login.SHARED_PREFS;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class homepage extends AppCompatActivity {
    ImageView openMenu;
    private ImageView imageView1, imageView2, imageView3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.homepage);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        Glide.with(this)
                .load(R.drawable.a3)
                .centerCrop()
                .into(imageView1);

        Glide.with(this)
                .load(R.drawable.s1)
                .centerCrop()
                .into(imageView2);

        Glide.with(this)
                .load(R.drawable.maldives)
                .centerCrop()
                .into(imageView3);

        openMenu=findViewById(R.id.profile);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(homepage.this,maldive.class);
                startActivity(i);

                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(homepage.this,sierra.class);
                startActivity(j);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(homepage.this,amazon.class);
                startActivity(j);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });

            openMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(homepage.this,v);
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
                                    Toast.makeText(homepage.this, "Logged Out,Sign In Again To Continue ", Toast.LENGTH_SHORT).show();

                                    Intent i= new Intent(getApplicationContext(),login.class);
                                    startActivity(i);
                                    finish();

                                    return true;

                                case R.id.contact:
                                    Toast.makeText(homepage.this, "www.hermes.com or hermeshelp@gmail.com ", Toast.LENGTH_SHORT).show();
                                    return true;

                                case R.id.bh:
                                    Toast.makeText(homepage.this, "To know Your Booking History Check Your registered Email ", Toast.LENGTH_LONG).show();
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