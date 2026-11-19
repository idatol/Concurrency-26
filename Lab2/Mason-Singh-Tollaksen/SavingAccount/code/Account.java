public class Account {

    private int balance = 0;

    // deposit is always possible
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " deposits " + amount + "   balance: " + balance);
        notifyAll();
    }

    // withdraw is only possible if it does not give a negative balance
    public synchronized void withdraw(int amount) throws InterruptedException {
        while (amount > balance) {
            System.out.println(Thread.currentThread().getName()
                    + " wants to withdraw " + amount + " but balance is "
                    + balance + ", has to wait");
            wait();
        }
        balance -= amount;
        System.out.println(Thread.currentThread().getName()
                + " withdraws " + amount + "  balance: " + balance);
    }
}
