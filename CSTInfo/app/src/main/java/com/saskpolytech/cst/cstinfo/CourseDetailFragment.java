package com.saskpolytech.cst.cstinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CourseDetailFragment extends Fragment implements CourseSelectedListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course_detail, container, false);
    }

    private void updateTextView(View v, int id, String val)
    {
        ((TextView)v.findViewById(id)).setText(val);
    }
    @Override
    public void setSelectedCourse(Course course) {
        View detailView = this.getView();
        updateTextView(detailView,R.id.tvName,course.name);
        updateTextView(detailView,R.id.tvCode,course.code);
        updateTextView(detailView,R.id.tvCredits,String.valueOf(course.credits));
        updateTextView(detailView,R.id.tvHours,String.valueOf(course.hours));
        updateTextView(detailView,R.id.tvDesc,course.desc);
    }
}