public class Cook extends Thread {

    PotNoWait pot;

    public Cook(PotNoWait pot) {
        this.pot = pot;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " would like to fill the pot");
            try {
                Thread.sleep(200);
                while (!pot.fillpot()) {   // pot not empty? 
                    Thread.sleep(200);     // go for a walk, then try again
                }
            }
            catch(InterruptedException e) {};
        }
    }
}