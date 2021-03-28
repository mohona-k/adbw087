/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import city.cs.engine.SoundClip;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MainGame {
    /**
     * Field storing levels
     */
    private GameLevel level;
    /**
     * Allows game to be viewed
     */
    private MyView view;
    /**
     * Stores music or sound clips used within the game
     */
    private SoundClip gameMusic;
    /**
     * Allows control of character movement
     */
    private MainController controller;

    public MainGame(){
        level = new Level1(this);

        try{
            gameMusic = new SoundClip("data/Kahoot.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e){
            System.out.println(e);
        }

        view = new MyView(this,600,345);
        view.setZoom(20);

        controller = new MainController(this);
        view.addKeyListener(controller);
        view.addMouseListener(new GiveFocus(view));



        final JFrame frame = new JFrame("World");
        frame.add(view);
        frame.addKeyListener(new MainController(this));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        //window cannot be resized
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        ControlPanel controlPanel = new ControlPanel();
        frame.add(controlPanel.getMainPanel(), BorderLayout.EAST);


        level.start();

    }

    //Constructors
    public GameLevel getLevel(){
        return level;
    }
    public MyView getView(){
        return view;
    }

    //Starts from level one
    public void setLevel(GameLevel level){
        this.level.stop();
        this.level = level;
        view.setWorld(this.level);
        this.level.start();
    }

    //To proceed to next level
    public void goToNextLevel() {

        if (level instanceof Level1) {
            level.stop();
            level = new Level2(this);
            view.setWorld(level);
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            level = new Level3(this);
            view.setWorld(level);
            level.start();
        } else if (level instanceof Level3) {
            System.out.println("Well done!");
            System.exit(0);

        }
    }



    public static void main (String[]args){
            new MainGame();
        }
}
