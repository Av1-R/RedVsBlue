public class CPUMoving implements State{
    String stateName = "SelectingTarget";
    Stage stage;

    public CPUMoving(Stage stage){
        this.stage = stage;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public void handle(int x, int y) {
    
    }


}