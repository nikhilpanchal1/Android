package com.example.cstinfov2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView itemList;
    ArrayList<Course> courses;
    CourseListAdapter adapter;


    private void Init()
    {
        courses = new ArrayList<>();
        courses.add(
                new Course(
                        "Business Principles",
                        "BUS182",
                        51,
                        3
                        )
        );
        courses.add(
                new Course(
                        "Operating Systems",
                        "COOS181",
                        68,
                        5
                        )
        );
        courses.add(
                new Course(
                        "Seminar",
                        "SEM183",
                        17,
                        1
                        )
        );
        courses.add(
                new Course(
                        "Workplace Skills",
                        "TCOM180",
                        68,
                        5
                        )
        );
        courses.add(
                new Course(
                        "Hardware",
                        "COHS190",
                        68,
                        5
                        )
        );
        courses.add(
                new Course(
                        "Intermediate Programming",
                        "COSC190",
                        90,
                        6
                )
        );

        itemList = findViewById(R.id.itemView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        itemList.setLayoutManager(manager);
        adapter = new CourseListAdapter(this, courses);
        itemList.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(itemList.getContext(),manager.getOrientation());
        itemList.addItemDecoration(dividerItemDecoration);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();
    }

    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
}