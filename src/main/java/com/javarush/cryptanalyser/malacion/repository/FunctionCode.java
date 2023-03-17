package com.javarush.cryptanalyser.malacion.repository;

import com.javarush.cryptanalyser.malacion.services.*;

public enum FunctionCode {
    ENCODE(new Encode()), DECODE(new Decode()), BRUTE_FORCE(new BruteForce()), UNSUPPORTED_FUNCTION(new UnsupportedFunction());

    private Function function;

    FunctionCode(Function function) {
        this.function = function;
    }

    public Function getFunction() {
        return this.function;
    }
}
