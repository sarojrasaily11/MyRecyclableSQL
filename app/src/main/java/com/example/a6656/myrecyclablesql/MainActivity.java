package com.example.a6656.myrecyclablesql;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.a6656.myrecyclablesql.database.MonsterDatabaseHelper;
import com.example.a6656.myrecyclablesql.entity.Monster;
import com.example.a6656.myrecyclablesql.recyclerView.MonsterRecyclerViewAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Monster> monsterList;
    MonsterRecyclerViewAdapter adapter;
    MonsterDatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        RecyclerView monsterRecyclerView = findViewById(R.id.monsterRecycleView);

        // set a layout manager

        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        //set the layout manager to my recycler view
        monsterRecyclerView.setLayoutManager(gridLayoutManager);

        database = new MonsterDatabaseHelper(this);
        //load data from the database

        monsterList = database.getMonsters();
        //create adapter passing the data
        adapter= new MonsterRecyclerViewAdapter(monsterList,this);
        //attach this adapter to the recycler view

        monsterRecyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
