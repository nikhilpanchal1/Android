package com.saskpolytech.cst.cstinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements CourseSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        CourseListFragment listFragment =
                (CourseListFragment) manager.findFragmentById(R.id.listFragment);

        //CourseDetailFragment detailFragment =(CourseDetailFragment) manager.findFragmentById(R.id.detailFragment);
        //listFragment.setCourseSelectedListener(detailFragment);
        listFragment.setCourseSelectedListener(this);
        Button button = findViewById(R.id.btnSort);
        button.setOnClickListener(v->listFragment.sort());
    }

    @Override
    public void setSelectedCourse(Course course) {
        //Toast.makeText(this,course.name, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,
                DetailActivity.class);
        intent.putExtra("name",course.name);
        intent.putExtra("code",course.code);
        intent.putExtra("hours",course.hours);
        intent.putExtra("credits",course.credits);
        intent.putExtra("desc",course.desc);
        startActivity(intent);
    }
}