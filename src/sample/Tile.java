package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {

    public Tile(int x, int y){
        setWidth(DiceRollSnake.Tile_Size);
        setHeight(DiceRollSnake.Tile_Size);

        setFill(Color.PINK);
        setStroke(Color.BLACK);
    }

}
