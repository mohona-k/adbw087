package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinsPickup implements CollisionListener {

    private Main main;
    public CoinsPickup(Main m){ this.main = m; }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Coins) {
            main.addCoins();
            e.getOtherBody().destroy();
        }
    }
}