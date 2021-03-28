package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class EnemyEncounter implements CollisionListener {


    private Enemy enemy;


    public EnemyEncounter(Enemy e){this.enemy = e;}

    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Main){
            e.getOtherBody().destroy();
        }
    }
}