package models;

import lombok.Data;

import java.util.Random;

@Data
public class Bot extends Player {

    private BotLevel level;

    public Bot(String name, char symbol,BotLevel level) {
        super(name,symbol);
    }

    @Override
    Pair<Integer,Integer> makeMove() {
        Random random = new Random();
        int x = random.nextInt();
        int y = random.nextInt();
        return new Pair<>(x,y);
    }
}
