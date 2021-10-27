package com.example.mcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonClicked(View v){
        EditText p = (EditText) findViewById(R.id.principle);
        String principle = p.getText().toString();
        EditText i = (EditText) findViewById(R.id.interest);
        String interest = i.getText().toString();
        EditText a = (EditText) findViewById(R.id.amortization);
        String amortization = a.getText().toString();
        MortgageModel mortgage = new MortgageModel(principle,amortization,interest);
        String output = mortgage.computePayment();
        ((TextView) findViewById(R.id.answer)).setText(output);


    }
}