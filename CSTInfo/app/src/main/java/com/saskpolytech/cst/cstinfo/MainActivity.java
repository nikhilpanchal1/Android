package com.saskpolytech.cst.cstinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        CourseListFragment listFragment =
                (CourseListFragment) manager.findFragmentById(R.id.listFragment);
        CourseDetailFragment detailFragment =
                (CourseDetailFragment) manager.findFragmentById(R.id.detailFragment);
        listFragment.setCourseSelectedListener(detailFragment);
    }
}