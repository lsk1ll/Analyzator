package com.javarush.cryptanalyzer.malacion.app;

import com.javarush.cryptanalyzer.malacion.controller.MainController;
import com.javarush.cryptanalyzer.malacion.entity.Result;
import com.javarush.cryptanalyzer.malacion.repository.FunctionCode;
import com.javarush.cryptanalyzer.malacion.services.Function;

import java.io.IOException;

import static com.javarush.cryptanalyzer.malacion.constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;
    public Application(MainController mainController) {
        this.mainController = mainController;
    }

    public Result run() throws IOException {
        String[] parameters =  mainController.getView().getParameters();
        String mode = parameters[0];
        Function function = getFunction(mode);
        return function.execute(parameters);
    }

    private Function getFunction(String mode) {
       return switch (mode){
            case "1" ->  FunctionCode.valueOf(ENCODE).getFunction();
            case "2" -> FunctionCode.valueOf(DECODE).getFunction();
            case "3" -> FunctionCode.valueOf(BRUTE_FORCE).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();
        };
    }
}
