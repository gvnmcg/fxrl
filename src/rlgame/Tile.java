package rlgame;

import engine.GameObject;
import javafx.scene.canvas.GraphicsContext;

public class Tile extends GameObject{


    public GameObject tileObj;
    public GameObject groundObj;

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(GraphicsContext g, double x, double y) {
        super.render(g, x, y);

        groundObj.render(g,x,y);

        tileObj.render(g,x,y);

    }
}
