package com.javarush.cryptanalyzer.malacion.services;

import com.javarush.cryptanalyzer.malacion.entity.Result;

public class UnsupportedFunction implements  Function{

    @Override
    public Result execute(String[] parameters) {
        return null;
    }
}
