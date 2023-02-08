package com.drone.app.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class FlightModel {

    private String id;

    private double Motor_temp_av;


    private double Battery_temp_av;


    private boolean rotor_issue;

    private long timestamp;

    public FlightModel(String id, double motor,  double battery, boolean rotor_i, long time){
        this.id=id;
        this.Motor_temp_av= motor;

        this.Battery_temp_av=battery;

        this.rotor_issue=rotor_i;
        this.timestamp=time;
    }

    public String getFlightId(){
        return id;
    }

    public double getMotor_temp() {
        return Motor_temp_av;
    }

    public double getBattery_temp() {
        return Battery_temp_av;
    }

    public boolean isRotor_issue() {
        return rotor_issue;
    }

    public long getTimestamp() {
        return timestamp;
    }
//@RequiresApi(api = Build.VERSION_CODES.0)
    public LocalDateTime getDateTime(){
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }
}
