package com.deepakbaliga.krishnaconchem;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research);

        ViewPager viewPager = (ViewPager) findViewById(R.id.research_viewpager);
        viewPager.setAdapter(new CustomResearchPagerAdapter(this));
    }
}
