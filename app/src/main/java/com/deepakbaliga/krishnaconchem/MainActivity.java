package com.deepakbaliga.krishnaconchem;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView productsImageView;
    private ImageView researchImageView;
    private ImageView publicationsImageView;
    private ImageView contactImageView;
    private ImageView majorUsersImageView;
    private ImageView certificationImageView;
    private ImageView technicalDatasheetsImageView;
    private ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productsImageView = (ImageView) findViewById(R.id.products_imageview);
        researchImageView = (ImageView) findViewById(R.id.research_imageview);
        publicationsImageView = (ImageView) findViewById(R.id.publication_imageview);
        contactImageView = (ImageView) findViewById(R.id.contact_imageview);
        logo = (ImageView) findViewById(R.id.logo);
        majorUsersImageView = (ImageView) findViewById(R.id.major_users_imageview);
        certificationImageView = (ImageView) findViewById(R.id.certification_imageview);
        technicalDatasheetsImageView = (ImageView) findViewById(R.id.technicaldatasheets_imageview);


        productsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CategoryActivity.class);
            }
        });



        ViewPager viewPager = (ViewPager) findViewById(R.id.aboutus_viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AboutUsActivity.class);
            }
        });

        researchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ResearchActivity.class);
            }
        });

        contactImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                FragmentManager fm = getSupportFragmentManager();
                ContactUsFragment fragment =  new ContactUsFragment();
                fragment.show(fm, "");

            }
        });


        publicationsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(PublicationsActivity.class);
            }
        });

        certificationImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                CertificationDialog fragment = new CertificationDialog();
                fragment.show(fm, "");
            }
        });

        majorUsersImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(MajorUsersActivity.class);
            }
        });

        technicalDatasheetsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TechnicalDatasheetsActivity.class);
            }
        });

        Glide.with(this).load(R.drawable.products).into(productsImageView);
        Glide.with(this).load(R.drawable.research).into(researchImageView);
        Glide.with(this).load(R.drawable.publications).into(publicationsImageView);
        Glide.with(this).load(R.drawable.contact).into(contactImageView);
        Glide.with(this).load(R.drawable.majorusers).into(majorUsersImageView);
        Glide.with(this).load(R.drawable.certification).into(certificationImageView);
        Glide.with(this).load(R.drawable.datasheet_icon).into(technicalDatasheetsImageView);


    }

    private void startActivity(Class aClass){
        startActivity(new Intent(MainActivity.this, aClass));
    }
}
