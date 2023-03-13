package com.javarush.cryptanalyzer.malacion.services;


import com.javarush.cryptanalyzer.malacion.constants.CryptanalyzerAlphabet;
import com.javarush.cryptanalyzer.malacion.entity.Result;
import com.javarush.cryptanalyzer.malacion.exception.ApplicationException;
import com.javarush.cryptanalyzer.malacion.repository.ResultCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class BruteForce implements Function{

    private static String bruteForce (String line){
        StringBuilder decryptedTextBuilder = new StringBuilder();
        Pattern pattern0 = Pattern.compile("[а-я], [а-я]");
        Pattern pattern1 = Pattern.compile("[а-я]\\. [А-Я]");

        int key = 0;
        while ((!pattern0.matcher(decryptedTextBuilder).find() &&
                !pattern1.matcher(decryptedTextBuilder).find())) {
            decryptedTextBuilder.setLength(0);
            for (int j = 0; j < line.length(); j++) {
                char ch = line.charAt(j);
                if (!CryptanalyzerAlphabet.ALPHABET.contains(String.valueOf(ch))) {
                    decryptedTextBuilder.append(ch);
                }
                if (CryptanalyzerAlphabet.ALPHABET.contains(String.valueOf(ch))) {
                    int index = CryptanalyzerAlphabet.ALPHABET.indexOf(ch);
                    ch = CryptanalyzerAlphabet.ALPHABET.charAt((index + key) % CryptanalyzerAlphabet.ALPHABET.length());
                    decryptedTextBuilder.append(ch);
                }
            }
            key++;
        }
        String decryptedText  = decryptedTextBuilder + System.lineSeparator() + "key: " + (85 - key);
        return decryptedText;
    }

    @Override
    public Result execute(String[] parameters) {

        Path pathEncode = Path.of(parameters[1]);
        Path pathOutput = Path.of(parameters[2]);

        try (BufferedReader inputFile = new BufferedReader(new FileReader(pathEncode.toFile()));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(pathOutput.toFile()))) {


            String inputLine;
            StringBuilder inputText = new StringBuilder();

            while ((inputLine = inputFile.readLine()) != null) {
                inputText.append(inputLine + System.lineSeparator());
            }
            outputFile.write(bruteForce(inputText.toString()));
            outputFile.newLine();
            outputFile.flush();
        }catch (Exception e){
            return new Result(ResultCode.ERROR , new ApplicationException("brute force exception", e));
        }
        return new Result(ResultCode.OK);
    }
}
