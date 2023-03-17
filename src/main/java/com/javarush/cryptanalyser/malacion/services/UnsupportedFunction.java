package com.javarush.cryptanalyser.malacion.services;

import com.javarush.cryptanalyser.malacion.entity.Result;

public class UnsupportedFunction implements  Function{

    @Override
    public Result execute(String[] parameters) {
        return null;
    }
}
