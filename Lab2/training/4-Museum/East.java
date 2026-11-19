package Museum;

// EAST = (arrive -> EAST).
public class East extends Thread {
    Control control;

    public East(Control control) {
        this.control = control;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
                control.arrive();
            }
            catch (InterruptedException e) {};
        }
    }
}
