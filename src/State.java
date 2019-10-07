public interface State{
    public String getStateName();
    public void handle(int x, int y);
}

