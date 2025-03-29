package models;

import lombok.Data;

import java.util.Scanner;

@Data
public class HumanPlayer extends Player{

    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }


    @Override
    public Pair<Integer,Integer> makeMove(Board board) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter position x:");
        Integer x = sc.nextInt();
        System.out.println("Enter position y:");
        Integer y = sc.nextInt();
        return new Pair<>(x,y);
    }

    void undo(){
        System.out.println("UNDO");
    }
}
