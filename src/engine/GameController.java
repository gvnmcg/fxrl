package engine;

import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * purpose:
 * - map UserInput(key actions) to (abs)GameAction s
 * - remap keys
 *
 */
public class GameController {

    HashMap<KeyEvent, String> actionMap = new HashMap<>();

    GameController(){

    }

    public HashMap<KeyEvent, String> getActionMap() {
        return actionMap;
    }

    public void putAction(KeyEvent key,  String action){
        actionMap.put(key, action);
    }

    public void reMapAction(KeyEvent key,  String action){
        if (actionMap.containsKey(key)){
            actionMap.put(key, action);
        }



    }



}
