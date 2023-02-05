package com.drone.app.models;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FlightModel {

    private String id;

    private double Motor_temp;

    private double Battery_temp;

    private boolean rotor_issue;

    private long timestamp;

    public FlightModel(String id, double motor, double battery, boolean rotor_i, long time){
        this.id=id;
        this.Motor_temp= motor;
        this.Battery_temp=battery;
        this.rotor_issue=rotor_i;
        this.timestamp=time;
    }

    public String getFlightId(){
        return id;
    }

    public double getMotor_temp() {
        return Motor_temp;
    }

    public double getBattery_temp() {
        return Battery_temp;
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
