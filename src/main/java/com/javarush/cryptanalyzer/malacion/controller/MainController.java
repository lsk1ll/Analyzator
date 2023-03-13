package com.javarush.cryptanalyzer.malacion.controller;

import com.javarush.cryptanalyzer.malacion.view.View;

public class MainController {
    View view;
    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    }
}
