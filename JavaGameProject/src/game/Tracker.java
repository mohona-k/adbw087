package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private MyView view;
    private MainGame game;
    public Tracker(MainGame game, MyView view){
        this.view = view;
        this.game = game;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        game.getView().setCentre(
                game.getLevel().getMain().getPosition()
                        .add(new Vec2(0,8)));
    }

}
