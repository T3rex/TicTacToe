package models.strategies.Bot_Playing_Strategies;

import models.Board;
import models.Pair;

public interface BotPlayingStrategy {

    Pair<Integer,Integer> makeMove(Board board);
}
