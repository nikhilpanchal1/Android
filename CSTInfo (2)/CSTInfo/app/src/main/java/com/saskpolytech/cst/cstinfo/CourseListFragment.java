package com.saskpolytech.cst.cstinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CourseListFragment extends Fragment {
    private RecyclerView courseList;
    private ArrayList<Course> courses;
    private  CourseSelectedListener listener;
    private  RecyclerView.Adapter courseAdapter;

    public void sort()
    {

        courses = courses.stream().
                sorted((a,b)->a.name.compareTo(b.name)).
                sorted((a,b)->a.code.compareTo(b.code)).
                collect(Collectors.toCollection(ArrayList::new));
        ((CourseListAdapter)courseAdapter).setCourses(courses);
        courseAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_course_list, container, false);
        courses = new ArrayList<>();
        courses.add(
                new Course(
                        "Business Principles",
                        "BUS182",
                        51,
                        3,
                        "You will be introduced to accounting, marketing and legal concepts used by computer systems technologists. You will gain an appreciation for the value of information presented in an organization's financial statements. You will acquire and practice basic bookkeeping and financial statement preparation skills. Your studies will also focus on service marketing concepts and skills. You will also examine legal concepts related to computer systems technology."
                )
        );
        courses.add(
                new Course(
                        "Operating Systems",
                        "COOS181",
                        68,
                        5,
                        "You will be introduced to the purpose and architecture of various operating systems. You will be provided an overview of the major operating system functions; installation, configuration and administration."
                )
        );
        courses.add(
                new Course(
                        "Seminar",
                        "SEM183",
                        17,
                        1,
                        "You will learn about topics of interest in the computer technology field from speakers representing various companies in industry."
                )
        );
        courses.add(
                new Course(
                        "Workplace Skills",
                        "TCOM180",
                        68,
                        5,
                        "You will develop the communication skills required in the workplace. You will learn time management skills, effective meeting practices and techniques for effective workplace communication. You will apply the interpersonal, oral, and written skills necessary in the job search. Your studies will include dealing with customers/clients, difficult people, subordinates, and inexperienced computer users."
                )
        );
        courses.add(
                new Course(
                        "Hardware",
                        "COHS190",
                        68,
                        5,
                        "You will be introduced to various computer hardware components. Your studies will cover the terminology associated with computer systems and peripherals. Additionally your studies will provide you with the opportunity to install boards, connect peripherals, set switches and configure microcomputer systems. Your studies will include the elements of WHMIS."
                )
        );
        courses.add(
                new Course(
                        "Intermediate Programming",
                        "COSC190",
                        90,
                        6,
                        "You will receive a further introduction to the concepts of object-oriented programming. You will study the design of classes and objects, and utilize standard file input/output techniques. You will become familiar with and be able to manipulate such advanced data structures as stacks and queues. The course content includes introductory GUI and thread-based programming."
                )
        );

        courseList = (RecyclerView) view.findViewById(R.id.courseList);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        courseList.setLayoutManager(manager);
        courseAdapter = new CourseListAdapter(getContext(), courses,
                new CourseListAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                     listener.setSelectedCourse(courses.get(pos));
            }
        });
        courseList.setAdapter(courseAdapter);
        return view;
    }

    public  void setCourseSelectedListener(CourseSelectedListener listener)
    {
        this.listener = listener;
    }

}