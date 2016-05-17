package com.deepakbaliga.krishnaconchem;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ViewPager viewPager = (ViewPager) findViewById(R.id.aboutus_viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));
    }
}
