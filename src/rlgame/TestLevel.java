package rlgame;

import engine.GameData;
import engine.GameObject;

import java.util.Random;

public class TestLevel extends Level {


    public TestLevel(GameData gameData, int width, int height) {
        super(width, height);

        Random rgen = new Random();
        gameData.addObject("grnd", new GameObject());
    }
}
