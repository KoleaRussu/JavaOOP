package com.example.lab5;

public class TemperatureConvert {

    double toCelsius(double temperatureToConvert) {
        return (5*(temperatureToConvert -32)) /9;
    }

    double toFahrenheit(double temperatureToConvert) {
        return (9* temperatureToConvert + (32*5)) / 5;
    }
}
