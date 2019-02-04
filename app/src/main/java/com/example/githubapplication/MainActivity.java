package com.example.githubapplication;


import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.githubapplication.Adapters.GithubAppPageAdapter;

public class MainActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private GithubAppPageAdapter pageAdapler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();

    }

    private void setUI() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pageAdapler = new GithubAppPageAdapter(getApplicationContext(), getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(pageAdapler);
        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < pageAdapler.getCount(); i++) {
            (((LinearLayout) ((LinearLayout) tabLayout
                    .getChildAt(0)).getChildAt(i))
                    .getChildAt(1)).setScaleY(-1);
        }

    }

}
