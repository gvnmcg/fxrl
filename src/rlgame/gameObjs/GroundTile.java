package rlgame.gameObjs;

import engine.GameObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import rlgame.RLGameData;
import rlgame.RLGameDataType;
import rlgame.RLRenderer;

public class GroundTile extends GameObject {


    public GroundTile(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    public GroundTile(String url, double x, double y) {
        super(url, x, y);

        this.dataType = RLGameData.MARK;

    }

    @Override
    public void render(GraphicsContext g, double x, double y) {
//        super.render(g, x, y);
        g.setFill(Color.BLACK);
        g.fillRect(x,y,w,h);

        g.setFill(Color.DARKGRAY);
        g.fillText("..", x,y);

    }
}
