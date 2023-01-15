package com.example.proiectfinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {
    private long lastUpdate;
    private long actualTime;
    private TextView tvTitle;
    private SensorManager sensorManager;
    private Sensor mySensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastUpdate = System.currentTimeMillis();
        tvTitle=findViewById(R.id.tvTitle);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (mySensor == null) {
            Toast.makeText(this, "No accelerometer detected in this device", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            sensorManager.registerListener((SensorEventListener) this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public int getRandomColor(){
        Random nr = new Random();
        int r = nr.nextInt(256);
        int g = nr.nextInt(256);
        int b = nr.nextInt(256);
        return Color.argb(255,r,g,b);
    }

    @Override
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnCPU) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("mode", "0");
            startActivity(intent);

        } else if (view.getId() == R.id.btnLocal) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("mode", "1");
            startActivity(intent);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] values = sensorEvent.values;
        float x = values[0];
        float y = values[1];
        float z = values[2];

        if (sensorEvent.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float EG = SensorManager.GRAVITY_EARTH;
            float devAcccel = (x * x + y * y + z * z) / (EG * EG);
            //System.out.println(devAcccel+"acceleratiuneaaa");
            if (devAcccel >= 1.005) {

                actualTime = System.currentTimeMillis();
               // System.out.println(actualTime - lastUpdate + "Hellllllllo");
                if ((actualTime - lastUpdate) > 1000) {
                    lastUpdate = actualTime;
                    tvTitle.setBackgroundColor(getRandomColor());
                    tvTitle.setText("Stop shaking me !!!");
                }
            }else {
                tvTitle.setBackgroundColor(Color.WHITE);
                tvTitle.setText("");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}