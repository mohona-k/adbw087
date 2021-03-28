package game;

import city.cs.engine.*;


public class Enemy extends Walker {
    private static final Shape enemyShape = new PolygonShape(
            -0.7f,1f,
            0.7f,1f,
            0.7f,-1f,
            -0.7f,-1f);



    private static final BodyImage image =
            new BodyImage("data/enemy.gif",5f);

    public Enemy(World world) {
        super(world, enemyShape);
        addImage(image);
    }


}
