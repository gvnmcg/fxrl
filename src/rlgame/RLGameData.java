package rlgame;

import engine.GameData;

import java.util.ArrayList;

public class RLGameData extends GameData {

    protected ArrayList<ArrayList<Tile>> tiles;

    public static final String PLAYER = "PLAYER";
    public static final String MARK = "MARK";
    public static final String FEAT = "FEAT";
    public static final String ACTOR = "ACTOR";



    public RLGameData(int width, int height) {
        super(width, height);
    }

    Tile getTile(int x, int y){
        return tiles.get(x).get(y);
    }
}
