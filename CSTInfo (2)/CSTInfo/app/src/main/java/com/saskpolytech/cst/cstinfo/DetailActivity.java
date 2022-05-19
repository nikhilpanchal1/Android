package com.saskpolytech.cst.cstinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        FragmentManager manager = getSupportFragmentManager();
        CourseDetailFragment detailFragment=(CourseDetailFragment)
                manager.findFragmentById(R.id.detailFragment);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        String code = bundle.getString("code");
        int hours = bundle.getInt("hours");
        int credits = bundle.getInt("credits");
        String desc = bundle.getString("desc");
        Course course = new Course(name,code,hours, credits,desc);
        detailFragment.setSelectedCourse(course);
        Button button = findViewById(R.id.btnClose);
        button.setOnClickListener(v->finish());
    }
}