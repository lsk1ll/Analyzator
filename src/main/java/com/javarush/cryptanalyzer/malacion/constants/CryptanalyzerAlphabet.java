package com.javarush.cryptanalyzer.malacion.constants;

public class CryptanalyzerAlphabet {
    private static final String LettersUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String LettersLowerCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String numbers = "0123456789";
    private static final String symbols = ".,\":-!? ";
    public static final String ALPHABET = LettersUpperCase + LettersLowerCase + numbers + symbols;
}
