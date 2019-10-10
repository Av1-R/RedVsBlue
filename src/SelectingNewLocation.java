import java.util.ArrayList;
import java.util.Optional;

public class SelectingNewLocation implements State {
    String stateName = "SelectingNewLocation";
    Stage stage;

    public SelectingNewLocation(Stage stage){
        this.stage = stage;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public void handle(int x, int y) {
        Optional<Cell> clicked = Optional.empty();
                for (Cell c : stage.cellOverlay) {
                    if (c.contains(x, y)) {
                        clicked = Optional.of(c);
                    }
                }
                if (clicked.isPresent() && stage.actorInAction.isPresent()) {
                    stage.cellOverlay = new ArrayList<Cell>();
                    stage.actorInAction.get().setLocation(clicked.get());
                    stage.actorInAction.get().turns--;
                    stage.menuOverlay.add(new MenuItem("Fire", x, y, () -> {
                        stage.cellOverlay = stage.grid.getRadius(stage.actorInAction.get().loc, stage.actorInAction.get().range, false);
                        stage.cellOverlay.remove(stage.actorInAction.get().loc);
                            stage.setState(stage.selectingTarget);
                    }));
                    stage.setState(stage.selectingMenuItem);
                } 
    
    }

    @Override
    public void handleCpu() {
        // Do nothing if currentState of CPU is not CPUMoving
        return;

    }


}