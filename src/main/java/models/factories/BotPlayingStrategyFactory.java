package models.factories;

import models.BotLevel;
import models.strategies.Bot_Playing_Strategies.BotPlayingStrategy;
import models.strategies.Bot_Playing_Strategies.EasyBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotLevel level) {
        switch (level) {
            case EASY:
                return new EasyBotPlayingStrategy();
            case MEDIUM:
                return new EasyBotPlayingStrategy();
            case HARD:
                return new EasyBotPlayingStrategy();
            default:
                return new EasyBotPlayingStrategy();
        }
    }
}
