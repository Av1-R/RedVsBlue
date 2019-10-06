public interface State{
    final static State ChoosingActor = new ChoosingActor();
    final static State SelectingNewLocation = new SelectingNewLocation();
    final static State SelectingMenuItem = new SelectingMenuItem();
    final static State SelectingTarget = new SelectingTarget();
    final static State CPUMoving = new CPUMoving();
    
    public void handle(Stage stage);
 

}