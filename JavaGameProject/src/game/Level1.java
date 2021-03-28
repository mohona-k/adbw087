/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class Level1 extends GameLevel implements ActionListener {
    /**
     * Has background image of game, changes every level
     */
    private Image background;

    private Random rand;
    public Level1(MainGame game){
        super(game);

        background = new ImageIcon("data/background.png").getImage();

        getMain().setPosition(new Vec2(8, -5));
        getChest().setPosition(new Vec2(-9,10));


        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(7, 10));
        EnemyEncounter encounter = new EnemyEncounter(enemy);
        enemy.addCollisionListener(encounter);


        getChest().addCollisionListener(encounter);
        getMain().addCollisionListener(new CoinsPickup(getMain()));

        //The ambience or world with static bodies
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -8f));


        Shape platform1Shape = new BoxShape(4, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.setPosition(new Vec2(-9, 2.5f));


        StaticBody platform2 = new StaticBody(this, platform1Shape);
        platform2.setPosition(new Vec2(5, 2f));

        StaticBody platform3 = new StaticBody(this, platform1Shape);
        platform3.setPosition(new Vec2(-3,-2));

        StaticBody platform4 = new StaticBody(this,platform1Shape);
        platform4.setPosition(new Vec2(3,-4.5f));

        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

        for (int i=0;i<3;i++){
            Coins coins = new Coins(this);
            coins.setPosition(new Vec2(i*2f,0));
        }

        //Timer respawns coins
        Timer t = new Timer(5000, this);
        t.start();

        rand = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Coins c = new Coins(this);
        c.setPosition(new Vec2(rand.nextFloat()*10,0));
    }

    @Override
    public boolean isComplete(){
        if (getMain().getCoinCount()>=3)
            return true;
        else
            return false;
    }

    @Override
    public Image getBackgroundImage(){
        return background;
    }


    @Override
    public String getLevelName(){
    return "Level1";
    }



}
