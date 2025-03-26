package models;

import Exceptions.InvalidBotCountException;
import Exceptions.InvalidCellException;
import lombok.Data;
import models.strategies.Winning_Algo_Strategies.OrderOneWinningStrategy;
import models.strategies.Winning_Algo_Strategies.PlayerWonStrategy;

import java.util.ArrayList;
import java.util.List;
@Data
public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayer;
    private int boardSize;
    private Gamestatus status;
    private List<Move> moveList;
    private PlayerWonStrategy playerWonStrategy;


    private Game(GameBuilder builder) {
        int n = builder.players.size();
        this.board = new Board(n+1);
        this.players = builder.players;
        this.currentPlayer = 0;
        this.boardSize = n+1;
        this.status = Gamestatus.IN_PROGRESS;
        this.moveList = new ArrayList<>();
        this.playerWonStrategy = new OrderOneWinningStrategy(n+1);
    }
    public static GameBuilder getBuilder() {
        return new GameBuilder();
    }

    public void printBoard(){
        board.printBoard();
    }


    public static class GameBuilder{
        private List<Player> players;

        public GameBuilder setPlayer(List<Player> players) {
            this.players = players;
            return this;
        }

        public Game build() throws InvalidBotCountException{
            int botCount=0;
            for(Player player : players){
                if(player instanceof Bot){
                    botCount++;
                    if(botCount>1){
                        throw new InvalidBotCountException("Only one bot is allowed, but found "+botCount);
                    }
                }
            }
            return new Game(this);
        }
    }

    public void makeMove() throws InvalidCellException{
        Player player = players.get(currentPlayer);
        Pair<Integer, Integer> position;
        Cell cell = null;

        while (true) {
            try {
                position = player.makeMove();
                cell = this.board.getCell(position.getX(), position.getY());

                if (board.isCellOccupied(cell)) {
                    System.out.println("Cell is occupied. Please choose another position.");
                } else {
                    break; // Valid and unoccupied cell
                }
            } catch (InvalidCellException e) {
                System.out.println("Invalid cell! Please enter valid coordinates.");
            }
        }

        this.board.setPlayer(cell.getX(), cell.getY(),player);


        Move move = new Move(this.board.getCell(cell.getX(),cell.getY()),player);
        this.moveList.add(move);



        if(playerWonStrategy.checkIfWon(cell)){
            this.status = Gamestatus.WIN;
            return;
        }
        if(moveList.size()==(players.size()+1)*(players.size()+1)){
            this.status = Gamestatus.DRAW;
            return;
        }
        this.currentPlayer = (this.currentPlayer+1)%players.size();

    }

    public  Player getWinner(){
        return this.players.get(currentPlayer);
    }

}
