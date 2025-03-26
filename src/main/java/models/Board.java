package models;

import Exceptions.InvalidCellException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> grid;

    public Board(int size){
        grid = new ArrayList<>();
        for(int i=0;i<size;i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0;j<size;j++){
                row.add(new Cell(i,j));
            }
            grid.add(row);
        }
    }

    public void printBoard(){
        for(List<Cell> row: grid){
            for(Cell cell: row){
                cell.print();
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public boolean isCellOccupied(Cell cell){
        int x = cell.getX();
        int y = cell.getY();
        return grid.get(x).get(y).getPlayer()!=null;
    }

    public boolean isValidCell(Cell cell){
        int x = cell.getX();
        int y = cell.getY();
        return x>=0 && x<grid.size() && y>=0 && y<grid.size();
    }

    public void setPlayer(int x, int y, Player player){
        Cell cell = grid.get(x).get(y);
        cell.setPlayer(player);
    }

    public Cell getCell(int x, int y) throws InvalidCellException {
        if(x<0 || x>=grid.size() || y<0 || y>=grid.size()){
            throw new InvalidCellException("Invalid cell");
        }
        return grid.get(x).get(y);
    }
}
