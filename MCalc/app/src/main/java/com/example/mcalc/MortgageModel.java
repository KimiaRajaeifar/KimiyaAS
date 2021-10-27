package com.example.mcalc;

import android.annotation.SuppressLint;

public class MortgageModel {
    private double interest;
    private double principle;
    private int amortization;

    public MortgageModel(String p, String a, String i){
         principle = Double.parseDouble(p);
         amortization =  Integer.parseInt(a);
         interest = Double.parseDouble(i);

    }
    @SuppressLint("DefaultLocale")
    public String computePayment(){
       double answer=  (((interest/100)/12)*principle)/(1-Math.pow((1+((interest/100)/12)),-amortization*12));
        return "$"+ String.format("%,.2f",answer);
    }
}
