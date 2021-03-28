/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import city.cs.engine.UserView;
import java.awt.*;

public class MyView extends UserView {
    private MainGame game;
    public MyView(MainGame game, int width, int height) {
        super(game.getLevel(), width, height);
        this.game = game;
    }

    @Override
    protected void paintBackground(Graphics2D g){
        g.drawImage(game.getLevel().getBackgroundImage(),0,0,this);
    }

}

