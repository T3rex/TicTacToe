package models.strategies.Winning_Algo_Strategies;

import models.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements PlayerWonStrategy {

    List<HashMap<Character,Integer>> rowMaps;
    List<HashMap<Character,Integer>> colMaps;
    HashMap<Character,Integer> diag1Map;
    HashMap<Character,Integer> diag2Map;
    int size;


    public OrderOneWinningStrategy(int size){
        this.size = size;
        this.rowMaps = new ArrayList<>();
        for(int i=0;i<size;i++){
            this.rowMaps.add(new HashMap<>());
        }

        this.colMaps = new ArrayList<>();
        for(int i=0;i<size;i++){
            this.colMaps.add(new HashMap<>());
        }

        this.diag1Map = new HashMap<>();
        this.diag2Map = new HashMap<>();
    }
    @Override
    public boolean checkIfWon(Cell cell) {

        int row = cell.getX();
        int col = cell.getY();
        char symbol = cell.getPlayer().getSymbol();

        rowMaps.get(row).put(symbol,rowMaps.get(row).getOrDefault(symbol,0)+1);
        colMaps.get(col).put(symbol,colMaps.get(col).getOrDefault(symbol,0)+1);

        if(row==col){
            diag1Map.put(symbol,diag1Map.getOrDefault(symbol,0)+1);
        }
        if(row+col==rowMaps.size()-1){
            diag2Map.put(symbol,diag2Map.getOrDefault(symbol,0)+1);
        }
        HashMap<Character, Integer> characterIntegerHashMap = rowMaps.get(row);

        if(rowMaps.get(row).get(symbol)==size){
            return true;
        }
        if(colMaps.get(col).get(symbol)==size){
            return true;
        }
        if(diag1Map.getOrDefault(symbol,0)==size){
            return true;
        }
        if(diag2Map.getOrDefault(symbol,0)==size){
            return true;
        }
        return false;

    }
}
