import java.util.Random;

public class Person extends Thread {

    private Account account;
    private int maxAmount;
    private Random random = new Random();

    public Person(Account account, int maxAmount) {
        this.account = account;
        this.maxAmount = maxAmount;
    }

    public void run() {
        try {
            while (true) {
                int amount = 1 + random.nextInt(maxAmount);
                if (random.nextBoolean()) {
                    account.deposit(amount);
                } else {
                    System.out.println(getName() + " would like to withdraw " + amount);
                    account.withdraw(amount);
                }
                Thread.sleep(random.nextInt(500));
            }
        } catch (InterruptedException e) {}
    }
}
