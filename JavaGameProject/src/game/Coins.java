/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import city.cs.engine.*;

public class Coins extends DynamicBody {

    private static final Shape coinsShape = new CircleShape(1);

    private static final BodyImage image =
            new BodyImage("data/coin.png", 2f);

    public Coins(World w) {
        super(w,coinsShape);
        addImage(image);

    }
}