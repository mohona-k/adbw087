/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ChestEncounter implements CollisionListener {

    private GameLevel level;
    private MainGame game;

    public ChestEncounter(GameLevel level, MainGame game){
        this.level = level;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Chest
                && level.isComplete()) game.goToNextLevel();
    }
}