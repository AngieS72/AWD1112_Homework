package edu.ranken.jpscott.presidents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddPresident extends AppCompatActivity {
    //Widgets
    Button   btnSave;
    Button   btnCancel;
    EditText etFirstName;
    EditText etLastName;
    EditText etServed;
    EditText etTheImage;
    TextView tvTheID;
    int id;
    List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_president);
        //  Get references to widgets
        btnSave     = findViewById(R.id.btnSave);
        btnCancel   = findViewById(R.id.btnCancel);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName  = findViewById(R.id.etLastName);
        etServed    = findViewById(R.id.etServed);
        etTheImage  = findViewById(R.id.etTheImage);
        tvTheID     = findViewById(R.id.tvTheID);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;

        presidentList = myApplication.getPresidentList();

        if (id >= 0)
        {
            //  Edit an existing President
            //  Find the President
            for (President p: presidentList) {
                if (p.getId() == id)
                {
                    president = p;
                }
            }

            //  Grab the current President's values and fill
            //  up the corresponding textView and editTexts.
            tvTheID.setText(String.valueOf(id));
            etFirstName.setText(president.getFirstName());
            etLastName.setText(president.getLastName());
            etServed.setText(president.getServed());
            etTheImage.setText(president.getTheImage());
        }

        // when clicked, this will save the editted or added personnel info.
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id >= 0)
                {
                    //  Update an existing president
                    President updatedPresident = new President(
                            id,
                            etFirstName.getText().toString(),
                            etLastName.getText().toString(),
                            etServed.getText().toString(),
                            etTheImage.getText().toString());

                    //  Add the updated President to the list
                    presidentList.set(id, updatedPresident);
                }
                else {
                    //  Put all below into a try/catch block!!!
                    //  Create a new President object
                    int nextId = myApplication.getNextId();
                    President newPresident = new President(
                            nextId,
                            etFirstName.getText().toString(),
                            etLastName.getText().toString(),
                            etServed.getText().toString(),
                            etTheImage.getText().toString());
                    presidentList.add(newPresident);
                    myApplication.setNextId(++nextId);
                }

                Intent intent = new Intent(AddPresident.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //When clicked, return user to opening activity.
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (AddPresident.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}