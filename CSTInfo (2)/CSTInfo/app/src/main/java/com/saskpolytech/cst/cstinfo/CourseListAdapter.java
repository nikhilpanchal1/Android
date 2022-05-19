package com.saskpolytech.cst.cstinfo;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.ViewHolder> {
    private ArrayList<Course> courses;
    private LayoutInflater inflater;
    private ItemClickListener itemClickListener;
    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }
    public  interface  ItemClickListener{
        void onItemClick(View view,int pos);
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public CourseListAdapter(Context context, ArrayList<Course> courses, ItemClickListener listener)
    {
        this.courses = courses;
        setItemClickListener(listener);
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvCourse.setText(course.toString());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tvCourse;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourse = itemView.findViewById(R.id.tvCourse);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(itemClickListener!=null) itemClickListener.onItemClick(view,getAdapterPosition());
        }
    }
}
