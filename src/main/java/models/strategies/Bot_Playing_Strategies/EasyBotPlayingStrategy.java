package models.strategies.Bot_Playing_Strategies;

import models.Board;
import models.Cell;
import models.Pair;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Pair<Integer, Integer> makeMove(Board board) {
        for(List<Cell> row : board.getGrid()){
            for(Cell cell : row){
                if(!cell.isOccupied()){
                    return new Pair<>(cell.getX(),cell.getY());
                }
            }
        }
        return null;
    }
}
