package com.sitalobr.dev.ropasciliz_spock.entity;

import java.util.Arrays;

public enum Option {
    ROCK(new String[]{"LIZARD", "SCISSORS"}),
    PAPER(new String[]{"ROCK", "SPOCK"}),
    SCISSORS(new String[]{"PAPER", "LIZARD"}),
    SPOCK(new String[]{"SCISSORS", "ROCK"}),
    LIZARD(new String[]{"SPOCK", "PAPER"});

    private String[] wins;

    Option(String[] wins) {
        this.wins = wins;
    }

    public Boolean wins(Option option) {
        return Arrays.asList(this.wins).contains(option.name());
    }
}
