package com.example.javamadeeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.javamadeeasy.adapters.MenuAdapter;
import com.example.javamadeeasy.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMenu;
    private List<Menu> menus;
    private MenuAdapter menuAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMenu = findViewById(R.id.recyclerViewMenu);

        menus = setMenuData();
        menuAdapter = new MenuAdapter(this, menus);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerViewMenu.setLayoutManager(gridLayoutManager);
        recyclerViewMenu.setAdapter(menuAdapter);


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