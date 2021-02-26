package edu.ranken.ashelton.currency_converter_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static edu.ranken.ashelton.currency_converter_sample.MainActivity.KEY;


public class results_Activity extends AppCompatActivity {
    //Declare widgets
    TextView tvResults;
    Button btnMainPage;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_);

        setContentView(R.layout.activity_results_);

        //Get reference to widge
        tvResults = findViewById(R.id.tvResults);
        btnMainPage = findViewById(R.id.btnMainPage);

        //Get the intent in the target activity
        Intent intent = getIntent();

        String str = intent.getStringExtra(KEY);
        tvResults.setText(str);
    }

    public void onClickGoToMainActivity(View view) {
        Intent m = new Intent(this, MainActivity.class);
        startActivity(m);
    }
}
