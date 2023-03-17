package com.javarush.cryptanalyser.malacion.services;


import com.javarush.cryptanalyser.malacion.constants.CryptanalyzerAlphabet;
import com.javarush.cryptanalyser.malacion.entity.Result;
import com.javarush.cryptanalyser.malacion.exception.ApplicationException;
import com.javarush.cryptanalyser.malacion.repository.ResultCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;

public class Decode implements Function{
    @Override
    public Result execute(String[] parameters) {

        Path pathInput = Path.of(parameters[1]);
        Path pathOutput = Path.of(parameters[2]);

        int shift = Integer.parseInt(parameters[3]);

        try (BufferedReader inputFile = new BufferedReader(new FileReader(pathInput.toFile()));
             BufferedWriter outputFile = new BufferedWriter(new FileWriter(pathOutput.toFile()))) {

            String inputLine;

            StringBuilder inputText = new StringBuilder();
            StringBuilder decryptedTextBuilder = new StringBuilder();

            while ((inputLine = inputFile.readLine()) != null) {
                inputText.append(inputLine + System.lineSeparator());
            }

            for (int i = 0; i < inputText.length(); i++) {
                char ch = inputText.charAt(i);
                if (CryptanalyzerAlphabet.ALPHABET.contains(String.valueOf(ch))) {
                    int index = CryptanalyzerAlphabet.ALPHABET.indexOf(ch);
                    ch = CryptanalyzerAlphabet.ALPHABET.charAt(
                            (index - shift + CryptanalyzerAlphabet.ALPHABET.length()) % CryptanalyzerAlphabet.ALPHABET.length());
                }
                decryptedTextBuilder.append(ch);
            }

            String decryptedText = decryptedTextBuilder.toString();

            outputFile.write(decryptedText);
            outputFile.flush();
        }catch (Exception e){
            return new Result(ResultCode.ERROR ,new ApplicationException("decode exception", e));
        }
        return new Result(ResultCode.OK);
    }
}
