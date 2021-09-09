package rlgame;

import engine.GameObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * set of Game Data
 */
public class Level extends RLGameData{

    protected LinkedList<GameObject> gameObjects = new LinkedList<>();
    protected HashMap<String, LinkedList<GameObject>> subsetMap = new HashMap<>();
    protected int width;
    protected int height;

    protected Random rGen = new Random();

    protected int WIDTH;
    protected int HEIGHT;

    public Level(int width, int height) {
        super(width, height);

    }

}
