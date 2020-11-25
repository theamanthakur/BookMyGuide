package com.twg.myguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    Button btnProfile,btnPlaces,btnTour,btnBook,btnCovid, btnGuide;
    private String[] urls = new String[]{"https://lp-cms-production.imgix.net/2020-08/shutterstockRF_1270999795.jpg", "https://static.toiimg.com/photo/63365869.cms", "https://en.unesco.org/sites/default/files/header_yearr_tourism_sus_dev2.jpg", "https://static.businessworld.in/article/article_extra_large_image/1495796491_AT6THj_Tourist-Taj-Mahal.jpg",
    "https://c4.wallpaperflare.com/wallpaper/961/859/615/newdelhi-redfort-landmark-sky-wallpaper-preview.jpg","https://c0.wallpaperflare.com/preview/738/999/763/travel-tourism-vacation-summer.jpg","https://c4.wallpaperflare.com/wallpaper/56/894/489/budhism-chumathang-countryside-explore-wallpaper-preview.jpg"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProfile = findViewById(R.id.buttonProfile);
        btnPlaces = findViewById(R.id.buttonPlace);
        btnTour = findViewById(R.id.buttonTour);
        btnBook = findViewById(R.id.buttonBook);
        btnCovid = findViewById(R.id.buttonCovid);
        btnGuide = findViewById(R.id.buttonGuide);
        btnPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,PlacesActivity.class));
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));

            }
        });
        btnTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,tourismActivity.class));
            }
        });
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,bookingActivity.class));
            }
        });
        btnCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,covidActivity.class));
            }
        });
        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,bookGuidActivity.class));
            }
        });

        init();
    }
    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this, urls));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = urls.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });


    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}