package com.example.mcalcpro;

import androidx.appcompat.app.AppCompatActivity;


import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Locale;

import ca.roumani.i2c.MPro;

public class MainActivity extends AppCompatActivity  implements  SensorEventListener, TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tts = new TextToSpeech(this,this);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
         sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
    }


    public void onInit(int initStatus){
        this.tts.setLanguage(Locale.US);
    }



    public void onSensorChanged(SensorEvent event) {
        double ax = event.values[0];
        double ay = event.values[1];
        double az = event.values[2];
        double a = Math.sqrt(ax*ax+ay*ay+az*az);
        if(a>20){
            ((EditText)findViewById(R.id.pBox)).setText("");
            ((EditText)findViewById(R.id.aBox)).setText("");
            ((EditText)findViewById(R.id.iBox)).setText("");
            ((TextView)findViewById(R.id.output)).setText("");
        }

    }


    public void onAccuracyChanged(Sensor arg0, int arg1) {

    }

    public void buttonClicked(View v){



        try {
            EditText p = (EditText) findViewById(R.id.pBox);
            String price = p.getText().toString();
            EditText i = (EditText) findViewById(R.id.iBox);
            String interest = i.getText().toString();
            EditText a = (EditText) findViewById(R.id.aBox);
            String amortization = a.getText().toString();


            MPro mp = new MPro();
            mp.setPrinciple(price);
            mp.setAmortization(amortization);
            mp.setInterest(interest);
            String s = "Monthly Payment=" + mp.computePayment("%,.2f");
            String t=s;
            s+="\n\n";
            s+="By making this payments monthly for"+ Double.parseDouble(amortization) +"years,";
            s+=(" the mortgage will be paid in full. But if you terminate the mortgage on its nth" + " anniversary, the balance still owing depends on n as shown below:");
            s+="\n\n";
            s+="\n\n";
            //s+="    n     Balance";
            s+=String.format("%8s", "n")+(String.format("%16s", "Balance"));

            for (int j = 0; j <= 5; j++) {

                s+="\n\n";
                s+=String.format("%8d", j)+mp.outstandingAfter(j, "%,16.0f");
            }
            for (int j = 10; j <= 20; j+=5) {

                s+="\n\n";
                s+=String.format("%8d", j)+mp.outstandingAfter(j, "%,16.0f");
            }
            s+="\n\n";



            ((TextView) findViewById(R.id.output)).setText(s);
            tts.speak(t,TextToSpeech.QUEUE_FLUSH,null);



        }
        catch (Exception e){
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            label.show();

        }








    }



}