import java.util.List;

public class CPUMoving implements State{
    String stateName = "CPUMoving";
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

    public void handleCpu(){
                //handled by Stage.paint() 
                for(Actor a: stage.actors){
                    if (!a.isTeamRed()){
                        List<Cell> possibleLocs = stage.getClearRadius(a.loc, a.moves, true);
        
                        Cell nextLoc = a.strat.chooseNextLoc(possibleLocs);
        
                        a.setLocation(nextLoc);
                    }
                }
                stage.setState(stage.choosingActor);
                for(Actor a: stage.actors){
                    a.turns = 1;
                }
        
    }


}