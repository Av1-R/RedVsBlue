import java.util.Optional;
import java.util.ArrayList;

public class SelectingTarget implements State {
    String stateName = "SelectingTarget";
    Stage stage;

    public SelectingTarget(Stage stage){
        this.stage = stage;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public void handle(int x, int y) {
        for(Cell c: stage.cellOverlay){
            if (c.contains(x, y)){
                Optional<Actor> oa = stage.actorAt(c);
                if (oa.isPresent()){
                    oa.get().makeRedder(0.1f);
                }
            }
        }
        stage.cellOverlay = new ArrayList<Cell>();
        stage.setState(stage.choosingActor);
    
    }


}