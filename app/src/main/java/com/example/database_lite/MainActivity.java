package com.example.database_lite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    EditText nameEdit;
    EditText ageEdit;
    Button saveButton, getDataButton, next_activity;
    PersonDataBase personDB;
    List<Person> personList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = findViewById(R.id.nameEdit);
        ageEdit = findViewById(R.id.ageEdit);

        next_activity = findViewById(R.id.next_activity);
        saveButton = findViewById(R.id.saveButton);
        getDataButton = findViewById(R.id.getDataButton);

        RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }
        };

        personDB = PersonDataBase.getDBinstance(this.getApplicationContext());

        // SAVE ------------------------------------------------------------------------------------
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                String age = ageEdit.getText().toString();
                Person p1 = new Person(name, age);

                addPersonInBackground(p1);

            }
        });

        // GET SAVE --------------------------------------------------------------------------------
        getDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getPersonListInBackground();
            }
        });

        next_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next_activity();
            }
        });


    }

    public void next_activity() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, MainActivityTwo.class);
                startActivity(intent);


            }
        });
    }

    public void addPersonInBackground(Person person) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                // background task

                personDB.getPersonDAO().addPerson(person);

                // on finishing background task

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Added to Database ", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    public void getPersonListInBackground() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                personList = personDB.getPersonDAO().getAllPerson();

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        StringBuilder sb = new StringBuilder();
                        for (Person p : personList) {
                            sb.append(p.getName()).append(" : ").append(p.getAge());
                            sb.append("\n");
                        }
                        String finalData = sb.toString();
                        Toast.makeText(MainActivity.this, " - " + finalData, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}