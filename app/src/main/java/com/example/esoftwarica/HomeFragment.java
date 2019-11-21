package com.example.esoftwarica;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.Adapter.adapterstudent;
import com.example.esoftwarica.Model.Students;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerViewHome;
    private static List<Students> studentsList = new ArrayList<> ();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.fragment_home, container, false);
       recyclerViewHome = root.findViewById (R.id.recyclerViewHome);

       Students students = new Students ("admin", "bhimsengola", "Male","19" ,R.drawable.others);
       studentsList = students.getStudentsList ();
       if(studentsList.isEmpty ()) {
           studentsList.add (new Students ("sadina magar", "bhimsengola", "Female", "20", R.drawable.female));
           studentsList.add (new Students ("suvekshya khanal", "aloknagar", "Female", "21", R.drawable.female));
           studentsList.add (new Students ("Akib manandhar", "swoyambhu", "Male", "23", R.drawable.maleimg));
           students.setStudentsList (studentsList);
       }
       adapterstudent Adapterstudents = new adapterstudent(getActivity (),studentsList);
       recyclerViewHome.setAdapter(Adapterstudents);
       recyclerViewHome.setLayoutManager (new LinearLayoutManager (getActivity (), LinearLayoutManager.VERTICAL,false));
       return root;


    }
}
