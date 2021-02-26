


package edu.ranken.ashelton.calculator_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener {
    // Declare and initialize global constant
    final String NOINPUT = "No Number Provided";
    final String NOOPSEL = "No Operator Selected";
    final String DIVBYZERO = "Cannot Divide By Zero";

    //Declare global program variables
    double firstNumber;
    double secondNumber;
    double result;
    String operator;
    String calcSymbol;
    String outputStr;

    //Declare program widgets
    Spinner spinnerOps;
    EditText etFirstNumber;
    EditText etSecondNumber;
    Button btnCalculate;
    Button btnClear;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get references to widgets
        spinnerOps = findViewById(R.id.spinnerOps);
        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        tvResults = findViewById(R.id.tvResults);

        //place focus when started in firstNumber EditText
        etFirstNumber.requestFocus();


        //If there is something chosen in the spinner, do the chosen operation
        if (spinnerOps != null) {
            spinnerOps.setOnItemSelectedListener(this);
        }

         //Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.operators,
                android.R.layout.simple_spinner_item);
        // //Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        if (spinnerOps != null) {
            //Apply the adapter to the spinner
            spinnerOps.setAdapter(adapter);
            spinnerOps.setOnItemSelectedListener(this);
        }

        //Initialize global variables
        firstNumber = 0.0;
        secondNumber = 0.0;
        result = 0.0;
        operator = "";
        calcSymbol = "";
        outputStr = "";

        //Reset all when clicked
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirstNumber.setText("");
                etSecondNumber.setText("");
                tvResults.setText("");
                result = 0.0;
                operator = "";
                calcSymbol = "";
                etFirstNumber.requestFocus();
            }
        });

        // First, make sure each number entered was a number.
        // Take the firstNumber & secondNumber and do the operation chosen.
        // Show calculation in reslt Textview.
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean keepGoing = validatefirstNumber();

                if (keepGoing) {
                    keepGoing = validatesecondNumber();
                } else {
                    return;
                }
                if (keepGoing) {
                    keepGoing = calculateresult();
                } else {
                    return;
                }
                if (keepGoing) {
                    outputStr = String.format("%.2f", firstNumber);
                    outputStr +="  " + calcSymbol + "  ";
                    outputStr += String.format("%.2f", secondNumber) + "  =  ";
                    outputStr += String.format("%.2f", result);
                    tvResults.setText(outputStr);
                }
            }
        });
    }

    //Check to make sure the entry is a number
    public boolean validatefirstNumber() {
        try {
            firstNumber = Double.parseDouble(etFirstNumber.getText().toString());
            return true;
        } catch (NumberFormatException nfe) {
            Toast.makeText(getApplicationContext(), NOINPUT, Toast.LENGTH_LONG).show();
            return false;
        }
    }

    //Check to make sure the entry is a number
    public boolean validatesecondNumber() {
        try {
            secondNumber = Double.parseDouble(etSecondNumber.getText().toString());
            return true;
        } catch (NumberFormatException nfe) {
            Toast.makeText(getApplicationContext(),
                    NOINPUT, Toast.LENGTH_LONG).show();
            return false;
        }
    }

    //Valid entries.
    //Do calculation.
    public boolean calculateresult() {
        if (((operator.equals("/")) || (operator.equals("%")) && (secondNumber == 0))) {
            Toast.makeText(getApplicationContext(),
                    DIVBYZERO, Toast.LENGTH_LONG).show();

            return false;
        } else {
            switch (calcSymbol) {

                case "+":
                    result = firstNumber + secondNumber;
                    break;

                case "-":
                    result = firstNumber - secondNumber;
                    break;

                case "*":
                    result = firstNumber * secondNumber;
                    break;

                case "/":
                    result = firstNumber / secondNumber;
                    break;

                case "%":
                    result = firstNumber % secondNumber;
                    break;
            }
            return true;
        }
    }


    @Override
    // An item was selected. You can retrieve the selected item using
    // parent.getItemAtPosition(pos)
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if (text.equals("+")) {
            //do this
            operator = "add";
            calcSymbol = "+";

        } else if (text.equals("-")) {
            //do this
            operator = "subtract";
            calcSymbol = "-";
        } else if (text.equals("*")) {
            //do this
            operator = "multiply";
            calcSymbol = "*";
        } else if (text.equals("/")) {
            //do this
            operator = "divide";
            calcSymbol = "/";
        } else if (text.equals("%")) {
            //do this
            operator = "modulus";
            calcSymbol = "%";
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Show a Toast since nothing was selected in spinner.
        Toast.makeText(getApplicationContext(),
                NOOPSEL, Toast.LENGTH_LONG).show();
    }


}




