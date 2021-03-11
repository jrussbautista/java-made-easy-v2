package com.example.javamadeeasy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.javamadeeasy.R;
import com.example.javamadeeasy.adapters.MenuAdapter;
import com.example.javamadeeasy.models.Menu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewMenu;
    private List<Menu> menus;
    private MenuAdapter menuAdapter;




    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewMenu = view.findViewById(R.id.recyclerViewMenu);

        menus = setMenuData();
        menuAdapter = new MenuAdapter(getContext(), menus);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenu.setLayoutManager(gridLayoutManager);
        recyclerViewMenu.setAdapter(menuAdapter);

        return view;
    }

    private ArrayList<Menu> setMenuData(){
        ArrayList<Menu> allMenus = new ArrayList<>();

        Menu menuLesson = new Menu("Lessons", getResources().getColor(R.color.indigo), R.drawable.ic_baseline_menu_book_24);
        Menu menuProgram = new Menu("Programs", getResources().getColor(R.color.green), R.drawable.ic_baseline_menu_book_24);
        Menu menuExercise = new Menu("Exercises", getResources().getColor(R.color.pink), R.drawable.ic_baseline_menu_book_24);
        Menu menuGlossary = new Menu("Glossary", getResources().getColor(R.color.teal), R.drawable.ic_baseline_menu_book_24);
        Menu menuImportantQuestion = new Menu("Important Questions", getResources().getColor(R.color.blue), R.drawable.ic_baseline_menu_book_24);
        Menu menuQuiz = new Menu("Quizzes", getResources().getColor(R.color.orange), R.drawable.ic_baseline_menu_book_24);


        allMenus.add(menuLesson);
        allMenus.add(menuProgram);
        allMenus.add(menuExercise);
        allMenus.add(menuImportantQuestion);
        allMenus.add(menuGlossary);
        allMenus.add(menuQuiz);
        return allMenus;
    }

}