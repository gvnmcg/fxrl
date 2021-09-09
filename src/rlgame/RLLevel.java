package rlgame;

import engine.GameObject;

import java.util.LinkedList;

public class RLLevel extends Level{


    public RLLevel(int width, int height) {
        super(width, height);
    }

    void randomlyPlaceFoliage(){

        LinkedList<GameObject> foliage = new LinkedList<>();

        int x = rGen.nextInt(WIDTH);
        int y = rGen.nextInt(HEIGHT);
        Tile t = tiles.get(x).get(y);

        for (GameObject go :
                this.gameObjects) {
            if ( t.groundObj == null ){
                t.groundObj = go;
            }
        }



        for (int i = 0; i < 29; i++) {

        }

        gameObjects.add(new GameObject());

    }
}
