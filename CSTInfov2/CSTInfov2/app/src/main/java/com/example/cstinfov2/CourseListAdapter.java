package com.example.cstinfov2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {

    private ArrayList<Course> courses;
    private LayoutInflater inflater;

    public CourseListAdapter(Context context, ArrayList<Course> courses)
    {
        this.inflater = LayoutInflater.from(context);
        this.courses = courses;
    }


    @NonNull
    @Override
    public CourseListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.courseinfo,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListAdapter.ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvName.setText(course.name);
        holder.tvCode.setText(course.code);
        holder.tvCredits.setText(String.valueOf(course.credits));
        holder.tvHours.setText(String.valueOf(course.hours));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvCode;
        TextView tvHours;
        TextView tvCredits;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txtName);
            tvCode = itemView.findViewById(R.id.txtCode);
            tvHours = itemView.findViewById(R.id.txtHour);
            tvCredits = itemView.findViewById(R.id.txtCredit);
        }

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
