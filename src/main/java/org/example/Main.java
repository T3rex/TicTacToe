package org.example;

import Exceptions.InvalidBotCountException;
import Exceptions.InvalidCellException;
import controllers.GameController;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InvalidBotCountException, InvalidCellException {
        GameController gameController = new GameController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of human playersList");
        int n = sc.nextInt();
        List<Player> playersList = new ArrayList<>();
        for(int i=0;i<n;i++){
            System.out.println("Enter name of player ");
            String name = sc.next();
            System.out.println("Enter symbol of player ");
            char symbol = sc.next().charAt(0);
            playersList.add(new HumanPlayer(name,symbol));
        }
        System.out.println("Do you want to add bot player?(Y/N)");
        if(sc.next().charAt(0)=='Y') {
            System.out.println("Enter level of bot player: 1 for Easy, 2 for Medium, 3 for Hard");
            int level = sc.nextInt();
            if(level==1) {
                playersList.add(new Bot("Bot-1", '#', BotLevel.EASY));
            }
            if(level==2) {
                playersList.add(new Bot("Bot-1", '#', BotLevel.MEDIUM));
            }
            if(level==3) {
                playersList.add(new Bot("Bot-1", '#', BotLevel.HARD));
            }
        }
        Game game = gameController.createGame(playersList);

        while(gameController.getGameStatus(game)==Gamestatus.IN_PROGRESS){
            gameController.makeMove(game);
            gameController.printBoard(game);
        }

        if(gameController.getGameStatus(game)==Gamestatus.WIN){
            Player winner = gameController.getGameWinner(game);
            System.out.println("Player "+winner.getName()+"-"+winner.getSymbol()+" won the game");
            gameController.printBoard(game);
        }
        else{
            System.out.println("Game Draw");
            gameController.printBoard(game);
        }

    }
}