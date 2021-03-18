package edu.ranken.jpscott.presidents;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
// Declare Widgets
    Button                     btnAddPresident;
    RecyclerView               recyclerView;
    RecyclerView.Adapter       mAdapter;
    RecyclerView.LayoutManager layoutManager;
    Menu menu;

    //List that holds all the presidents that will be viewed via recyclerview
    List<President> presidentList;

    MyApplication myApplication = (MyApplication) this.getApplication();

    //Initialization code goes here.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presidentList = myApplication.getPresidentList();

        //  Get references to widgets
        btnAddPresident  = findViewById(R.id.btnAddPresident);
        recyclerView     = findViewById(R.id.rvPresidents);

        recyclerView.setHasFixedSize(true);

        //implementation which provides similar functionality to ListView - will list the presidents
        //layout manager arranges the items in the Recyclerview - Recyclerview library provides
        // three layout managers:  LinearLayoutManager, GridLayoutManager, and
        // Staggered Grid Layout Manager.  LinearLayoutManager arranges items in
        // a one-dimensional list.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Adapter creates Viewholder objects as needed and sets the data for those views.
        // This process is called binding.
        mAdapter = new CustomAdapter(presidentList, this);
        recyclerView.setAdapter(mAdapter);

        // When the Add President button is clicked, the AddPresident activity will open
        btnAddPresident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPresident.class);
                startActivity(intent);
            }
        });
    }

    // Creates menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    // the menu items that allow user to choose how to display items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.menuSortLastNameAscending:
                Collections.sort(presidentList, President.LastNameAscComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuSortLastNameDescending:
                Collections.sort(presidentList, President.LastNameDescComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuSortTermAscending:
                Collections.sort(presidentList, President.TermAscComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuSortTermDescending:
                Collections.sort(presidentList, President.TermDescComparator);
                mAdapter.notifyDataSetChanged();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}