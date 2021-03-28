/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */

package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main extends Walker{
    private static final Shape mainShape = new PolygonShape(
            -0.11f,1.2f,
            0.6f,0.3f,
            0.6f,-1.4f,
            -0.6f,-1.4f,
            -0.8f,0.3f);
    private static SoundClip loseSound;
    static{
        try{
            loseSound = new SoundClip("data/lose.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/orange.gif",5f);

    private int coinCount;

    public Main(World world) {
        super(world, mainShape);
        addImage(image);

        coinCount = 0;

    }
    @Override
    public void destroy()
    {
        loseSound.play();
        super.destroy();
    }

    //coinCount will be incremented as main character picks them up
    public void addCoins(){
        coinCount++;
        System.out.println("Coin(s) count: "+ coinCount);
    }

    //Used for when saving data to file
    public int getCoinCount(){return coinCount;}

    public void setCoinCount(int cc){
        coinCount = cc;
    }




    }


