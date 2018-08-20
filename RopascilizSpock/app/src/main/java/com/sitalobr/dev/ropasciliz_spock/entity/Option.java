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

    /**
     * Checks the winner of a match
     * @param otherOption Other {@link Option} to compare to
     * @return Returns {@link ResultComparison}.LOSS in case that this {@link Option} loses,
     * {@link ResultComparison}.DRAW if it's a draw and {@link ResultComparison}.WIN
     * if this {@link Option} wins
     */
    public ResultComparison checkWinner(Option otherOption) {
        return Arrays.asList(this.wins).contains(otherOption.name()) ? ResultComparison.WIN :
                this.equals(otherOption) ? ResultComparison.DRAW : ResultComparison.LOSS;
    }
}
