package com.mrq.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.mrq.library.RoundView.RoundView;
import com.mrq.library.RoundView.TabAdapter;
import com.mrq.library.RoundView.TabClass;

import java.util.ArrayList;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        RoundView roundview = findViewById(R.id.roundview);
        TabLayout tabLayout = findViewById(R.id.tab);
        ViewPager pager = findViewById(R.id.v_pager);

        ArrayList<TabClass> tabs = new ArrayList<>();
        tabs.add(new TabClass("ASD", new BlankFragment()));
        tabs.add(new TabClass("ASD", new BlankFragment()));
        tabs.add(new TabClass("ASD", new BlankFragment()));
        tabs.add(new TabClass("ASD", new BlankFragment()));
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), tabs);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
        roundview.setViewPager(pager, true);
    }
}