package com.example.database_lite;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivityTwo extends AppCompatActivity {
    PersonDataBase personDB;
    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        initRecyclerView();
        getAllCategoryList();
    }


    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public void getAllCategoryList() {
        PersonDataBase db = PersonDataBase.getDBinstance(this.getApplicationContext());
        List<Person> userList = db.getPersonDAO().getAllPerson();
        adapter.setUserList(userList);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            getAllCategoryList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}