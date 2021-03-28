/**
 * @author      Mohona, Kar, mohona.kar@city.ac.uk
 * @version     1.0
 * @since       March 2021
 */
package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class MainController implements KeyListener{

    private MainGame game;

    private static final float JUMPING_SPEED = 7;
    private static final float WALKING_SPEED = 4;

    public MainController(MainGame game) {
        this.game = game;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_SPACE){
            Vec2 v = game.getLevel().getMain().getLinearVelocity();
            if (Math.abs(v.y)< 0.1f) {
                game.getLevel().getMain().jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT){
            game.getLevel().getMain().startWalking(-WALKING_SPEED);
        } else if (code == KeyEvent.VK_RIGHT){
            game.getLevel().getMain().startWalking(WALKING_SPEED);
        } else if (code == KeyEvent.VK_S){
            try {
                GameSaverLoader.save(game.getLevel(),"data/save.txt");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else if (code == KeyEvent.VK_L){
            try {
                GameLevel level = GameSaverLoader.load(game,"data/save.txt");
                game.setLevel(level);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT){
            game.getLevel().getMain().stopWalking();
        }
        else if (code == KeyEvent.VK_RIGHT){
            game.getLevel().getMain().stopWalking();
        }
    }
}