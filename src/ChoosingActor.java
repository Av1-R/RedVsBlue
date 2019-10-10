import java.util.Optional;

public class ChoosingActor implements State {
    String stateName = "SelectingTarget";
    Stage stage;

    public ChoosingActor(Stage stage){
        this.stage = stage;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public void handle(int x, int y) {
        stage.actorInAction = Optional.empty();
        for (Actor a : stage.actors) {
            if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                stage.cellOverlay = stage.grid.getRadius(a.loc, a.moves, true);
                stage.actorInAction = Optional.of(a);
                stage.setState(stage.selectingNewLocation);
            }
        }
        if(!stage.actorInAction.isPresent()){
            stage.setState(stage.selectingMenuItem);
            stage.menuOverlay.add(new MenuItem("Oops", x, y, () -> stage.setState(stage.choosingActor)));
            stage.menuOverlay.add(new MenuItem("End Turn", x, y+MenuItem.height, () -> stage.setState(stage.CPUMoving)));
            stage.menuOverlay.add(new MenuItem("End Game", x, y+MenuItem.height*2, () -> System.exit(0)));
        }
    }
    
    @Override
    public void handleCpu() {
        // Do nothing if currentState of CPU is not CPUMoving
        return;

    }
}