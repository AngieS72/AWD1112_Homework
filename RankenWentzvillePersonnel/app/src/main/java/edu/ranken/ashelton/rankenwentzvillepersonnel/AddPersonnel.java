package edu.ranken.ashelton.rankenwentzvillepersonnel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddPersonnel extends AppCompatActivity {
    // Widgets.
    Button btnSave;
    Button btnCancel;
    EditText etFirstName;
    EditText etLastName;
    EditText etDivision;
    EditText etTheImage;
    TextView tvTheID;
    int id;
    List<Personnel> PersonnelList;
    MyApplication myApplication = (MyApplication) this.getApplication();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_personnel);
        //  Get references to widgets
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etDivision = findViewById(R.id.etDivision);
        etTheImage = findViewById(R.id.etDivImage);
        tvTheID = findViewById(R.id.tvTheID);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        Personnel personnel = null;

        PersonnelList = myApplication.getPersonnelList();

        if (id >= 0) {
            //  Edit an existing Personnel
            //  Find the personnel
            for (Personnel p : PersonnelList) {
                if (p.getId() == id) {
                    personnel = p;
                }
            }

            //  Grab the current Personnel's values and fill
            //  up the corresponding textView and editTexts.
            tvTheID.setText(String.valueOf(id));
            etFirstName.setText(personnel.getFirstName());
            etLastName.setText(personnel.getLastName());
            etDivision.setText(personnel.getDivision());
            etTheImage.setText(personnel.getTheImage());
        }

        // when clicked, this will save the editted or added personnel info.
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id >= 0) {
                    //  Update an existing employee
                    Personnel updatedPersonnel = new Personnel(
                            id,
                            etFirstName.getText().toString(),
                            etLastName.getText().toString(),
                            etDivision.getText().toString(),
                            etTheImage.getText().toString());

                    //  Add the updated Personnel to the list
                    PersonnelList.set(id, updatedPersonnel);
                } else {
                    //  Put all below into a try/catch block!!!
                    //  Create a new Personnel object
                    int nextId = myApplication.getNextId();
                    Personnel newPersonnel = new Personnel(
                            nextId,
                            etFirstName.getText().toString(),
                            etLastName.getText().toString(),
                            etDivision.getText().toString(),
                            etTheImage.getText().toString());
                    PersonnelList.add(newPersonnel);
                    myApplication.setNextId(++nextId);
                }

                Intent intent = new Intent(AddPersonnel.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //When clicked, return user to opening activity.
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddPersonnel.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}