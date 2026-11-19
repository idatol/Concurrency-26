public class Savage extends Thread {

    PotNoWait pot;  

    public Savage(PotNoWait pot) { 
        this.pot = pot;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " is hungry and would like to eat ");
            try {
                Thread.sleep(200);
                while (!pot.getserving()) {   // didn't get food? 
                    Thread.sleep(200);        // go for a walk, then try again
                }
            }
            catch(InterruptedException e) {};
        }
    }
}