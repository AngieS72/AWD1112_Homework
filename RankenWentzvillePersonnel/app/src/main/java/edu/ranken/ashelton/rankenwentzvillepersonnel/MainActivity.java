
package edu.ranken.ashelton.rankenwentzvillepersonnel;

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
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//Declare widgets
    Button btnAddEdit;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    Menu menu;

    //List that holds all the personnel that will be viewed via recyclerview
    List<Personnel> PersonnelList;

    MyApplication myApplication = (MyApplication) this.getApplication();

    // Initialization code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonnelList = myApplication.getPersonnelList();

        //  Get references to widgets
        btnAddEdit = findViewById(R.id.btnAddEdit);
        recyclerView = findViewById(R.id.rvPersonnel);

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
        mAdapter = new CustomAdapter(PersonnelList, this);
        recyclerView.setAdapter(mAdapter);

        //This provides a toast (pop-up message) upon start of the program to let user
        // know starting personnel count.
        String str = "Total Number Of Ranken Wentzville Personnel: 27";
        Toast toast = Toast.makeText(this, str, Toast.LENGTH_LONG);
        toast.show();

        //When the Add/Edit button is clicked, the AddPersonnel activity will open on
        // screen.
        btnAddEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddPersonnel.class);
                startActivity(intent);
            }
        });
    }

    //creates menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    // the menu items that allow user to choose how to display items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSortLastNameAscending:
                Collections.sort(PersonnelList, Personnel.LastNameAscComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuSortLastNameDescending:
                Collections.sort(PersonnelList, Personnel.LastNameDescComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuSortDivisionAscending:
                Collections.sort(PersonnelList, Personnel.DivisionAscComparator);
                mAdapter.notifyDataSetChanged();
                return true;

            case R.id.menuSortDivisionDescending:
                Collections.sort(PersonnelList, Personnel.DivisionDescComparator);
                mAdapter.notifyDataSetChanged();
                return true;
        }

        // super refers to the instance of the parent class
        return super.onOptionsItemSelected(item);
    }
}
