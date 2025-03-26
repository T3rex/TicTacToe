package controllers;

import Exceptions.InvalidBotCountException;
import Exceptions.InvalidCellException;
import models.Game;
import models.Gamestatus;
import models.Player;

import java.util.List;

public class GameController {

    public  Game createGame(List<Player> playerList) throws InvalidBotCountException {
        return Game.getBuilder().setPlayer(playerList).build();
    }

    public Gamestatus getGameStatus(Game game){
        return game.getStatus();
    }

    public void makeMove(Game game) throws InvalidCellException {
        game.makeMove();
    }

    public Player getGameWinner(Game game){
        return game.getWinner();
    }


    public void printBoard(Game game){
        game.printBoard();
    }
}
