package edu.ranken.ashelton.myweatherapp;

import com.google.gson.annotations.SerializedName;

public class MainData {
    @SerializedName("temp")
    private double temperature;

    //right mouse click and use Generate --> Getter =
    public double getTemperature() {
        return temperature;
    }

    @SerializedName("temp_min")
    private double tempMin;

    public double getTempMin() {return tempMin;}

}
