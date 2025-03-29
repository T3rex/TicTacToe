package models;

import lombok.Data;

@Data
public class Cell {
    private int x;
    private int y;
    private Player player;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Cell(Cell cell){
        this.x = cell.getX();
        this.y = cell.getY();
    }

    public void print(){
        if(player!=null){
            System.out.print(" "+ player.getSymbol()+" ");
        }
        else{
            System.out.print(" _ ");
        }
    }

    public boolean isOccupied(){
        return player!=null;
    }

    public void setPlayer(Player player){
        this.player = player;
    }
}
