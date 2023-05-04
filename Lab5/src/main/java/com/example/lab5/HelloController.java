package com.example.lab5;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.text.DecimalFormat;

public class HelloController {

    public RadioButton RadioC;
    public RadioButton RadioF;
    public Label ResultText;
    public Button ButtonB;
    public TemperatureConvert temperatureConverter;
    public TextField InputL;

    public HelloController() {
        this.temperatureConverter = new TemperatureConvert();
    }

    public void onButtonClik() {
        String valueToConvert = InputL.getText();
        if (valueToConvert == null || valueToConvert.trim().length() == 0) {
            return;
        }

        try {
            double convertedTemperature = convertValue(parseToDouble(valueToConvert), getConversionType());
            displayResult(convertedTemperature);
        }catch (ConversionFailedException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private char getConversionType() {
            if (RadioC.isSelected()) {
                return 'C';
            }
            if (RadioF.isSelected()) {
                return 'F';
            }
            return '\u0000';
        }

    private double convertValue(double valueToConvert, char conversionType){
            switch (conversionType) {
                case 'C':
                    return temperatureConverter.toCelsius(valueToConvert);

                case 'F':
                    return temperatureConverter.toFahrenheit(valueToConvert);

                default:
                    throw new IllegalArgumentException("Unknown converion type!");
            }
        }

        private void displayResult(double convertedTemperature){
            DecimalFormat df = new DecimalFormat("#.###");
            ResultText.setText(df.format(convertedTemperature));
        }
        private double parseToDouble(String valueToConvert) {
        try{
            return Double.parseDouble(valueToConvert);
        }catch (NumberFormatException ex) {
            String errMgs = String.format("Got and invalid value to convert: %s",ex.getMessage());
            System.out.println(errMgs);
            throw  new ConversionFailedException(errMgs);
        }
        }

    public void OnKeyPressed(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            onButtonClik();
        }
    }
}
