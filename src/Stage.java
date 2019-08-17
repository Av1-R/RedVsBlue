import java.awt.*;

public class Stage {
    Grid grid;
    Actor puppy;
    Actor lion;
    Actor rabbit;

    public Stage(){
        grid = new Grid();
        puppy = new Puppy(grid.cellAtColRow(0, 0));
        lion = new Lion(grid.cellAtColRow(0, 18));
        rabbit = new Rabbit(grid.cellAtColRow(14,3));
    }

    public void paint(Graphics g, Point mouseLoc){
        grid.paint(g,mouseLoc);
        puppy.paint(g);
        lion.paint(g);
        rabbit.paint(g);
    }
}