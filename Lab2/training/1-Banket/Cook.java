public class Cook extends Thread {

    Pot pot;

    public Cook(Pot pot) {
        this.pot = pot;
    }

    public void run() {
        while (true) {
            System.out.println(...);
            try {
                Thread.sleep(200);
                pot.refill();
            }
            catch(InterruptedException e) {
                
            };
        }
    }
}
