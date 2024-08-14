package com.example.database_lite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivityTwo extends AppCompatActivity {
    PersonDataBase personDB;
    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;
    List<ItemList> itemLists = new ArrayList<>();
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        generateItem();

    }


  private void initRecyclerView() {
        personDB = PersonDataBase.getDBinstance((getApplication().getApplicationContext()));
        itemLists = new ArrayList<>();
        adapter = new MyAdapter(this, itemLists);
        recyclerView.setAdapter(adapter);
//        adapter = new MyAdapter(this);
    }

    public void getAllCategoryList() {
        List<Person> categoryList = personDB.getPersonDAO().getAllPerson();
        adapter.setUserList(categoryList);

    }
    private void generateItem() {

        //-------------------------------

        itemLists.add(new
                ItemList("Ivan", 22));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new
                LinearLayoutManager(this));
        recyclerView.setAdapter(new
                MyAdapter(getApplicationContext(), itemLists));


        //-------------------------------------------------
    }
}