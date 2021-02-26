package edu.ranken.ashelton.currency_converter_sample;

/*
        Problem #2. Create an Android app called CurrencyConverter.

        Two possibly helpful URLs: https://www1.oanda.com/currency/converter/
        and https://www.xe.com/currencyconverter/

        Use the 4 most popular currencies, i.e.:
        1) US dollar.  2) European Euro.  3) Japanese Yen.  4) British Pound.

        If a user puts the same currency for both the FROM and TO, provide a
        toast which lets them no there is no conversion to be done.

        Add a 2nd activity with the FROM currency , the TO currency, and each
        inputted/calculated currency amount.  Design the interface as you see fit
        https://www.xe.com/symbols.php
 */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //  String Constants
    final String NEGATIVE = "NEGATIVE ";
    final String IP = "NO INPUT PROVIDED FOR AMOUNT TO CONVERT";
    final String NC = "NO CONVERTING RATE TO ITSELF";

    //Currency Symbols
    final String DOLLAR = "\u0024";
    final String EURO = "\u20ac";
    final String YEN = "\u00A5";
    final String POUND = "\u00A3";

    //  Conversion Constants
    final double USD_To_EEURO = 0.82280;
    final double USD_To_JYEN = 105.73;
    final double USD_To_BPOUND = 0.70707;

    final double EEURO_USD = 1.21523;
    final double EEURO_TO_JYEN = 128.49;
    final double EEURO_TO_BPOUND = 0.85928;

    final double JYEN_TO_USD = 0.00946;
    final double JYEN_TO_EEURO = 0.00778;
    final double JYEN_TO_BPOUND = 0.00669;

    final double BPOUND_TO_USD = 1.41411;
    final double BPOUND_TO_JYEN = 149.52;
    final double BPOUND_TO_EEURO = 1.6335;

    //  I provided US Dollar conversion rates
    //  US DOLLAR TO CONVERSIONS

    //  Widgets
    EditText editTextAmount;
    Spinner spinnerFrom;
    Spinner spinnerTo;
    Button buttonConvert;


    //	Global variables
    boolean keepGoing;          //Program continue variable
    double inputtedAmount;
    double conversionRate;
    double convertedAmount;
    String convertFrom;
    String convertTo;
    String cFSymbol;
    String cTSymbol;
    int from;                   //Number 0-3
    int to;                     //Number 0-3
    DecimalFormat df = new DecimalFormat("###,###,##0.#####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  Get references to widgets
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        editTextAmount = findViewById(R.id.editTextAmount);
        buttonConvert = findViewById(R.id.buttonConvert);

        //  Initialize global variables
        keepGoing = true;
        inputtedAmount = 0.0;
        conversionRate = 0.0;
        convertedAmount = 0.0;
        from = -1;
        to = -1;
        convertFrom = "";
        convertTo = "";
        cFSymbol = "";
        cTSymbol = "";

// allows the hardware component to talk to the program
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.currencies_array,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        //  Set adapter to spinners
        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keepGoing = checkForInvalidInput();

                if (keepGoing) {
                    doTheConversion();
                }
            }
        });
    }

    private boolean checkForInvalidInput() {
        try {
            inputtedAmount = Double.parseDouble(editTextAmount.getText().toString());

            // check for negative number input
            if (inputtedAmount < 0) {
                Toast.makeText(getApplicationContext(),
                        NEGATIVE + IP,
                        Toast.LENGTH_LONG).show();
                editTextAmount.requestFocus();
                return false;
            }
            return true;
        } catch (NumberFormatException nfe) {
            Toast.makeText(getApplicationContext(),
                    IP,
                    Toast.LENGTH_LONG).show();
            editTextAmount.requestFocus();
            return false;
        }
    }

    public static final String KEY = "key";

    private void doTheConversion() {
        from = spinnerFrom.getSelectedItemPosition();
        to = spinnerTo.getSelectedItemPosition();

        switch (from) {
            case 0:  //From selected US Dollar
                convertFrom = " US Dollars";
                cFSymbol = DOLLAR;

                switch (to) {
                    case 0:
                        conversionRate = 0;
                        Toast.makeText(getApplicationContext(),
                                NC, Toast.LENGTH_LONG).show();
                        break;

                    case 1:
                        conversionRate = USD_To_EEURO;
                        convertTo = toType(1);


                        break;
                    case 2:
                        conversionRate = USD_To_JYEN;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = USD_To_BPOUND;
                        convertTo = toType(3);
                        break;
                }
                break;
            case 1:  // from selected euro
                convertFrom = "European Euros";
                cFSymbol = EURO;
                switch (to) {
                    case 0:
                        conversionRate = EEURO_USD;
                        convertTo = toType(0);

                        break;

                    case 1:
                        conversionRate = 0;
                        Toast.makeText(getApplicationContext(),
                                NC, Toast.LENGTH_LONG).show();
                        break;

                    case 2:
                        conversionRate = EEURO_TO_JYEN;
                        convertTo = toType(2);
                        break;
                    case 3:
                        conversionRate = EEURO_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                }
                break;
            case 2:  //from yen
                convertFrom = "Japanese Yen";
                cFSymbol = YEN;
                switch (to) {
                    case 0:
                        conversionRate = JYEN_TO_USD;
                        convertTo = toType(0);
                        break;

                    case 1:
                        conversionRate = JYEN_TO_EEURO;
                        convertTo = toType(1);

                        break;
                    case 2:
                        conversionRate = 0;
                        Toast.makeText(getApplicationContext(),
                                NC, Toast.LENGTH_LONG).show();
                        break;

                    case 3:
                        conversionRate = JYEN_TO_BPOUND;
                        convertTo = toType(3);
                        break;
                }
                break;
            case 3:  //from pound
                convertFrom = "British Pound";
                cFSymbol = POUND;

                switch (to) {
                    case 0:
                        conversionRate = BPOUND_TO_USD;
                        convertTo = toType(0);
                        break;

                    case 1:
                        conversionRate = BPOUND_TO_EEURO;
                        convertTo = toType(1);
                        break;

                    case 2:
                        conversionRate = BPOUND_TO_JYEN;
                        convertTo = toType(2);
                        break;

                    case 3:
                        conversionRate = 0;
                        Toast.makeText(getApplicationContext(),
                                NC, Toast.LENGTH_LONG).show();
                        break;
                }


            default:
                break;
        }

        if (conversionRate != 0) {
            convertedAmount = inputtedAmount * conversionRate;

            String str = cFSymbol + df.format(inputtedAmount);
            str += convertFrom + " = ";
            str += cTSymbol + df.format(convertedAmount);
            str += convertTo;

            //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), results_Activity.class);
            intent.putExtra(KEY, str);
            startActivity(intent);

        }
    }


    private String toType(int fromType) {
        String retVal = "";

        switch (fromType) {
            case 0:
                retVal = " US Dollars";
                cTSymbol = DOLLAR;
                break;

            case 1:
                retVal = " European Euros";
                cTSymbol = EURO;
                break;

            case 2:
                retVal = " Japanese Yen";
                cTSymbol = YEN;
                break;

            case 3:
                retVal = " British Pounds";
                cTSymbol = POUND;
                break;
        }
        return retVal;
    }
}