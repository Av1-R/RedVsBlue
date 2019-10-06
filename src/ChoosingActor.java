import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.*;

public class ChoosingActor implements State{
    int currentState = ChoosingActor;
    Stage stage;

    @Override
    public void handle(Stage stage) {
        this.stage = StageReader.readStage("data/stage1.rvb");
        for (Actor a : stage.actors) {
            if (a.loc.contains(stage.mouseLoc.x, mouseLoc.y) && a.isTeamRed() && a.turns > 0) {
                stage.cellOverlay = stage.grid.getRadius(a.loc, a.moves, true);
                stage.actorInAction = Optional.of(a);
                currentState = State.SelectingNewLocation;
            }
        }
    }


}