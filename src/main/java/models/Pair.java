package models;

import lombok.Data;

@Data
public class Pair<X,Y> {
    X x;
    Y y;

    public Pair(X x, Y y){
        this.x = x;
        this.y = y;
    }
}
