package Museum;

// WEST = (leave -> WEST).
public class West extends Thread {
    Control control;

    public West(Control control) {
        this.control = control;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                control.leave();
            }
            catch (InterruptedException e) {};
        }
    }
}
