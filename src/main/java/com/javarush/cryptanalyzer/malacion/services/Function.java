package com.javarush.cryptanalyzer.malacion.services;

import com.javarush.cryptanalyzer.malacion.entity.Result;

public interface Function {
    Result execute(String[] parameters);
}
