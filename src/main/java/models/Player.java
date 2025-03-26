package models;

import lombok.Data;

@Data
public abstract class Player {
    protected String name;
    protected char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    abstract Pair<Integer,Integer> makeMove();
}
