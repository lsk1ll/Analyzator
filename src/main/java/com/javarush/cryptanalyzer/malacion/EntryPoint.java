package com.javarush.cryptanalyzer.malacion;

import com.javarush.cryptanalyzer.malacion.app.Application;
import com.javarush.cryptanalyzer.malacion.controller.MainController;
import com.javarush.cryptanalyzer.malacion.entity.Result;
import com.javarush.cryptanalyzer.malacion.view.ConsoleView;
import com.javarush.cryptanalyzer.malacion.view.View;


import java.io.IOException;

public class EntryPoint {
    public static void main(String[] args) throws IOException {
        View view = new ConsoleView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        switch (result.getResultCode()){
            case OK -> System.out.println("successfully");
            case ERROR -> System.out.println("error:" + result.getApplicationException().getMessage());
        }

    }
}