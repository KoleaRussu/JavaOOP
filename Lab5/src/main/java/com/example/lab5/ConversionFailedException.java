package com.example.lab5;

import java.lang.reflect.Constructor;

public class ConversionFailedException extends RuntimeException{
    public ConversionFailedException(String message){
        super(message);
    }
}
