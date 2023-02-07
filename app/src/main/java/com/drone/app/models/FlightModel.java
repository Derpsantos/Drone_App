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

    private List<Double> motor_temps;

    private double Battery_temp_av;

    private List<Double> battery_temps;

    private boolean rotor_issue;

    private long timestamp;

    public FlightModel(String id, double motor, List<Double> motor_temps, double battery, List<Double> battery_temps, boolean rotor_i, long time){
        this.id=id;
        this.Motor_temp_av= motor;
        this.motor_temps = motor_temps;
        this.Battery_temp_av=battery;
        this.battery_temps=battery_temps;
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
