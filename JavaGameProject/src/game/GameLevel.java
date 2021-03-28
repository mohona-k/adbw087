package game;

import city.cs.engine.World;
import java.awt.*;


public abstract class GameLevel extends World {
    private Main main;
    private Chest chest;


    public GameLevel(MainGame game){
        main = new Main(this);
        chest = new Chest(this);
        ChestEncounter encounter = new ChestEncounter(this,game);
        main.addCollisionListener(encounter);
    }

    public Main getMain(){return main;}
    public Chest getChest(){return chest;}
    public abstract boolean isComplete();
    public abstract Image getBackgroundImage();

    public abstract String getLevelName();

}
