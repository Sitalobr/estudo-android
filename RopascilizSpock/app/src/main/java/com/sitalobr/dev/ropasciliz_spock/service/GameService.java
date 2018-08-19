package com.sitalobr.dev.ropasciliz_spock.service;

import com.sitalobr.dev.ropasciliz_spock.entity.Option;

import java.util.Random;

public class GameService {

    private Random random;

    public GameService() {
        this.random = new Random();
    }

    public Option randomlyChooseAppOption() {
        Option[] options = Option.values();
        int i = this.random.nextInt(options.length);
        return options[i];
    }

}
