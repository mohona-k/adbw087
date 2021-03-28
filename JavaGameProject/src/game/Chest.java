/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import city.cs.engine.*;


public class Chest extends Walker {
    private static final Shape chestShape = new PolygonShape(
            0f,1.4f,
            1.3f,1.4f,
            1.3f,0.29f,
            1.3f,-1.4f,
            -1.12f,-1.27f,
            -1.24f,1.21f);


    private static final BodyImage image =
            new BodyImage("data/chest.png",3f);


    public Chest(World world) {
        super(world, chestShape);
        addImage(image);
    }

}