package com.javarush.cryptanalyser.malacion;

import com.javarush.cryptanalyser.malacion.app.Application;
import com.javarush.cryptanalyser.malacion.controller.MainController;
import com.javarush.cryptanalyser.malacion.entity.Result;
import com.javarush.cryptanalyser.malacion.view.ConsoleView;
import com.javarush.cryptanalyser.malacion.view.View;


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