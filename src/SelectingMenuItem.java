import java.util.ArrayList;

public class SelectingMenuItem implements State{
    String stateName = "SelectingTarget";
    Stage stage;

    public SelectingMenuItem(Stage stage){
        this.stage = stage;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public void handle(int x, int y) {
        for(MenuItem mi : stage.menuOverlay){
            if (mi.contains(x,y)){
                mi.action.run();
                stage.menuOverlay = new ArrayList<MenuItem>();
            }
        }
    
    }

    @Override
    public void handleCpu() {
        // Do nothing if currentState of CPU is not CPUMoving
        return;

    }


}