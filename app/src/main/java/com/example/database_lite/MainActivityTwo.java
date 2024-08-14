package com.example.database_lite;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivityTwo extends AppCompatActivity {
    PersonDataBase personDB;
    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;
//    List<ItemList> itemLists = new ArrayList<>();
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

//        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

//        generateItem();
        initRecyclerView();
        getAllCategoryList();
    }


  private void initRecyclerView() {
//        personDB = PersonDataBase.getDBinstance((getApplication().getApplicationContext()));
//        itemLists = new ArrayList<>();
//        adapter = new MyAdapter(this, itemLists);
//        recyclerView.setAdapter(adapter);

      RecyclerView recyclerView = findViewById(R.id.recyclerView);
      recyclerView.setLayoutManager(new LinearLayoutManager(this));

      DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
      recyclerView.addItemDecoration(dividerItemDecoration);
      adapter = new MyAdapter(this);
      recyclerView.setAdapter(adapter);

    }

    public void getAllCategoryList() {
//        List<Person> categoryList = personDB.getPersonDAO().getAllPerson();
//        adapter.setUserList(categoryList);
//
//        PersonDataBase db = PersonDataBase.getDBinstance(this.getApplicationContext());
//        List<Person> userList =db.getPersonDAO().getAllPerson();
//        adapter.setUserList(userList);

        PersonDataBase db = PersonDataBase.getDBinstance(this.getApplicationContext());
        List<Person> userList =db.getPersonDAO().getAllPerson();
        adapter.setUserList(userList);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            getAllCategoryList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void generateItem() {

        //-------------------------------

//        itemLists.add(new
//                ItemList("Ivan", 22));
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new
//                LinearLayoutManager(this));
//        recyclerView.setAdapter(new
//                MyAdapter(getApplicationContext()));


        //-------------------------------------------------
    }
}