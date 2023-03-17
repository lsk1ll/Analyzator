package com.javarush.cryptanalyser.malacion.view;

import java.util.Scanner;

public class ConsoleView implements View {
    @Override
    public String[] getParameters() {

        String[] parameters = new String[4];
        Scanner console = new Scanner(System.in);
        System.out.println("""
                select operating mode:
                 1 - Encode
                 2 - Decode
                 3 - BruteForce""");

        parameters[0] = console.nextLine();
        switch (parameters[0]) {
            case "1" -> {
                System.out.println("file for input:");
                parameters[1] = console.nextLine();

                if (parameters[1].isEmpty()) {
                    parameters[1] = "input.txt";
                }

                System.out.println("file for encoded txt:");
                parameters[2] = console.nextLine();

                if (parameters[2].isEmpty()) {
                    parameters[2] = "encoded.txt";
                }
                System.out.println("shift for encodeCaesar");
                parameters[3] = console.nextLine();

                if (parameters[3].isEmpty()) {
                    parameters[3] = "3";
                }
            }
            case "2" -> {
                System.out.println("file for input:");
                parameters[1] = console.nextLine();

                if (parameters[1].isEmpty()) {
                    parameters[1] = "input.txt";
                }

                System.out.println("file for output:");
                parameters[2] = console.nextLine();

                if (parameters[2].isEmpty()) {
                    parameters[2] = "output.txt";
                }
                System.out.println("shift for decodeCaesar");
                parameters[3] = console.nextLine();

                if (parameters[3].isEmpty()) {
                    parameters[3] = "3";
                }
            }
            case "3" -> {
                System.out.println("file for encoded text:");
                parameters[1] = console.nextLine();
                if (parameters[1].isEmpty()) {
                    parameters[1] = "input.txt";
                }
                System.out.println("file for output:");
                parameters[2] = console.nextLine();
                if (parameters[2].isEmpty()) {
                    parameters[2] = "output.txt";
                }
            }
        }
        console.close();
        return parameters;
    }
}
