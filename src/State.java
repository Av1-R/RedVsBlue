public interface State{
    final static int ChoosingActor = 0;
    final static int SelectingNewLocation = 1;
    final static int SelectingMenuItem = 2;
    final static int SelectingTarget = 3;
    
    public void handle(Stage stage);
 

}