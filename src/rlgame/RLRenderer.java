package rlgame;

import engine.GameData;
import engine.GameObject;
import engine.Renderer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;
import java.util.LinkedList;

public class RLRenderer extends Renderer {

    final private int SCALE = 20;
    final private int NUM_H = 30;
    final private int NUM_W = 20;

    final static int WIDTH = 600;
    final static int HEIGHT = 400;
//    final int WIDTH = NUM_W * SCALE;
//    final int HEIGHT = NUM_H * SCALE;


//    public static final int SCALE = 20;
    private int xoffset = 50;
    private int yoffset = 0;

    GameData gameData;

    HashMap<String, Paint> colorPallet = new HashMap<>();

    public RLRenderer(GraphicsContext g) {
        super(g, WIDTH, HEIGHT);
    }

    public RLRenderer(GraphicsContext g, double width, double height) {
        super(g, width, height);
    }
    public RLRenderer(GraphicsContext g, double width, double height, GameData gameData) {
        super(g, width, height);


        this.gameData = gameData;

        colorPallet.put(RLGameData.MARK, Color.BLACK);
        colorPallet.put(RLGameData.PLAYER, Color.BLUE);
    }

    public void render(GameObject gameObject) {
        gameObject.render(g, gameObject.x * SCALE, gameObject.y * SCALE);
    }

    public void renderList(String key) {

        g.setFill(Color.RED);
        g.fillRect(60,20,50,50);

        g.setFill(colorPallet.get(key));

        try {
            LinkedList<GameObject> goList = gameData.getList(key);

            for (GameObject go : goList) {

                go.render(g,
                        go.x * SCALE,
                        go.y * SCALE );
//                g.setFill(Color.LIGHTGREEN);
//                g.fillRect(
//                        go.x * RLRenderer.SCALE,
//                        go.y * RLRenderer.SCALE,
//                        20, 20);
//
//                g.setFill(Color.GREEN);
//                g.fillText(
//                        "hi",
//                        go.x* RLRenderer.SCALE,
//                        go.y* RLRenderer.SCALE
//                );
                render(go);
            }
        } catch (NullPointerException e){
            System.out.println("no list " + key);
//            System.exit(0);
            return;
        }

        return;
    }



}
