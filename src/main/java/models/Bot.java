package models;

import lombok.Data;
import models.factories.BotPlayingStrategyFactory;
import models.strategies.Bot_Playing_Strategies.BotPlayingStrategy;

import java.util.Random;

@Data
public class Bot extends Player {

    private BotLevel level;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol,BotLevel level) {
        super(name,symbol);
        this.level = level;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(level);
    }


    @Override
    Pair<Integer,Integer> makeMove(Board board) {
        return botPlayingStrategy.makeMove(board);
    }
}
