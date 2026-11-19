package Museum;

// ||MUSEUM = (EAST || WEST || DIRECTOR || CONTROL).
public class Museum {
    public static void main(String args[]) {
        Control control = new Control();
        Thread east = new East(control); east.setName("east");
        Thread west = new West(control); west.setName("west");
        Thread director = new Director(control); director.setName("director");
        east.start();
        west.start();
        director.start();
    }
}
