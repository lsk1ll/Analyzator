package com.javarush.cryptanalyser.malacion.services;

import com.javarush.cryptanalyser.malacion.entity.Result;

public interface Function {
    Result execute(String[] parameters);
}
