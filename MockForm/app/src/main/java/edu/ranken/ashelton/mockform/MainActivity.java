package edu.ranken.ashelton.mockform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    //This program needs to grab what user entered and print in toast when image button is clicked.


    //Global Constants
    final String NIP = "No Input Provided.";        //NIP = NO input provided to indicate user missed a field


    //  Get references to widgets
    //widgets
    EditText etName;
    EditText etAddress;
    EditText etCity;
    Spinner spinnerState;
    EditText etZipCode;
    RadioButton rbMale;
    RadioButton rbFemale;
    RadioButton rbNoAnswer;
    CheckBox cbMorning;
    CheckBox cbAfternoon;
    CheckBox cbEvening;
    ToggleButton tbSettings;
    ImageButton ibGoSign;

    //Global variables
    boolean keepGoing;          //Program continue variable
    String name;
    String address;
    String city;
    String state;
    String zip;
    String gender;
    String shift;
    String on;
    String off;
    String results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        spinnerState = findViewById(R.id.spinnerState);
        etZipCode = findViewById(R.id.etZipCode);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbNoAnswer = findViewById(R.id.rbNoAnswer);
        cbMorning = findViewById(R.id.cbMorning);
        cbAfternoon = findViewById(R.id.cbAfternoon);
        cbEvening = findViewById(R.id.cbEvening);
        tbSettings = findViewById(R.id.tbSettings);
        /*Add in Oncreate() funtion after setContentView()*/
        ImageButton ibGoSign  = findViewById(R.id.ibGoSign);
        ibGoSign.setImageResource(R.drawable.go); //set the image programmatically

        //  Initialize global variables
        keepGoing = true;       //Program continue variable
        String name = "";
        String address = "";
        String city = "";
        String state = "";
        String zip = "";
        String gender = "";
        String shift = "";
        String results = "";


        // allows the hardware component to talk to the program
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.statesSpinner,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        //  Set adapter to spinners
        spinnerState.setAdapter(adapter);

        ibGoSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keepGoing = checkForInvalidInput();

                if (keepGoing) {
                    showInfo();
                }
            }
        });
    }

    private boolean checkForInvalidInput() {
        checkForName();
        checkAddress();
        checkCity();
        checkZipCode();
        return true;
    }


    private boolean checkForName() {
        if (name != null) {
            etName.getText().toString().trim();
        } else {
            Toast.makeText(getApplicationContext(),
                   "Name: " + NIP,
                    Toast.LENGTH_LONG).show();
            etName.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkAddress() {
        if (address != null) {
            etAddress.getText().toString().trim();
        } else {
            Toast.makeText(getApplicationContext(),
                  "Address: " +  NIP,
                    Toast.LENGTH_LONG).show();
            etAddress.requestFocus();
            return false;
        }
        return true;
    }

    private boolean checkCity() {
        if (city != null) {
            etCity.getText().toString().trim();
        } else {
            Toast.makeText(getApplicationContext(),
                    "City: " + NIP,
                    Toast.LENGTH_LONG).show();
            etCity.requestFocus();
            return false;
        }
        return true;
    }


    private boolean checkZipCode() {
        if (zip != null) {
            etZipCode.getText().toString().trim();

        } else {
            Toast.makeText(getApplicationContext(),
                    "Zip: " + NIP,
                    Toast.LENGTH_LONG).show();
            etZipCode.requestFocus();
            return false;
        }
        return true;
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rbFemale:
                if (checked)
                    gender = "Female";
                break;
            case R.id.rbMale:
                if (checked)
                    gender = "Male";
                break;
            case R.id.rbNoAnswer:
                if (checked)
                    gender = "Prefer Not To Answer";
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.cbMorning:
                if (checked)
                    shift = "Morning";
                break;

            case R.id.cbAfternoon:
                if (checked)
                    shift = "Afternoon";

                break;
            case R.id.cbEvening:
                if (checked)
                    shift = "Evening";
        }
    }

    public void showInfo() {
        results = "NAME: " + name +
                "\nADDR: " + address +
                "\nCITY: " + city +
                "\nSTATE: " + state +
                "\nZIP: " + zip +
                "\nGender: " + gender +
                "\nShift: " + shift;

        Toast.makeText(getApplicationContext(),
                results,
                Toast.LENGTH_LONG).show();
    }

}
