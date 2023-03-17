package com.javarush.cryptanalyser.malacion.controller;

import com.javarush.cryptanalyser.malacion.view.View;

public class MainController {
    View view;
    public MainController(View view) {
        this.view = view;
    }

    public View getView() {
        return this.view;
    }
}
