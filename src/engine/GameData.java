package engine;


import rlgame.Level;
import rlgame.TestLevel;

import java.util.*;

/**
 * purpose  - abstract set of the Data set I would access
 *          - arranged into lists and sets
 */
public class GameData {

    protected LinkedList<GameObject> gameObjects = new LinkedList<>();
    protected HashMap<String, LinkedList<GameObject>> subsetMap = new HashMap<>();
    protected int width;
    protected int height;

    boolean DEBUG = true;

    public GameData(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addObject(String key, GameObject object) {
        if (DEBUG) System.out.println("added " + object.toString() + " to " + key);

        if (subsetMap.containsKey(key)) {
            subsetMap.get(key).add(object);
            if (DEBUG) System.out.println("obj added to " + key);
        } else {
            if (DEBUG) System.out.println("make new list: " + key);
            LinkedList<GameObject> ls = new LinkedList<>();
            ls.add(object);
            subsetMap.put(key, ls);
        }
        gameObjects.add(object);
    }

    public LinkedList<GameObject> getList(String key) {
        return subsetMap.get(key);
    }


    public void addObjectList(String loadID, LinkedList<GameObject> loadList){

        subsetMap.put(loadID, loadList);
        gameObjects.addAll(loadList);
    }

    public void buildObjectList(int rowN, int colN, int space, String loadID, LinkedList<GameObject> loadList){

        subsetMap.put(loadID, loadList);
        gameObjects.addAll(loadList);
    }


    public void loadLevel(Level testLevel) {
    }
}
