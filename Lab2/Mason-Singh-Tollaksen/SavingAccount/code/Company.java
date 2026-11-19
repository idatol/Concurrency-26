import java.util.Random;

public class Company extends Thread {

    private Account account;
    private int maxAmount;
    private Random random = new Random();

    public Company(Account account, int maxAmount) {
        this.account = account;
        this.maxAmount = maxAmount;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                account.deposit(1 + random.nextInt(maxAmount));
            }
        } catch (InterruptedException e) {}
    }
}
