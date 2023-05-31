package com.mgdapps.easybrowser;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    ViewPager vp_viewpager;
    TabLayout tl_tablayout;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.tb_toolbar);
        setSupportActionBar(toolbar);

        vp_viewpager=(ViewPager) findViewById(R.id.vp_viewpager);
        tl_tablayout=(TabLayout)findViewById(R.id.tl_tablayout);


        FragmentPagerAdapter fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager());

        fragmentPagerAdapter.addfragment(new FragOne(),"Direct Links");
        fragmentPagerAdapter.addfragment(new FragTwo(),"Browser");

        vp_viewpager.setAdapter(fragmentPagerAdapter);
        tl_tablayout.setupWithViewPager(vp_viewpager);




    }
    @Override
    public void onBackPressed() {
        if (FragTwo.wv_searchWeb!=null) {
            if (FragTwo.wv_searchWeb.canGoBack()) {
                FragTwo.wv_searchWeb.goBack();
            }
        }
    }

}