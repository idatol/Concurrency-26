package Museum;

// DIRECTOR = (open -> close -> DIRECTOR).
public class Director extends Thread {
    Control control;

    public Director(Control control) {
        this.control = control;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                control.open();
                Thread.sleep(2000);
                control.close();
            }
            catch (InterruptedException e) {};
        }
    }
}
