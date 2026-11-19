public class SavingAccount {
    public static void main(String args[]) {
        Account account = new Account();

        Thread alice   = new Person(account, 10);  alice.setName("alice");
        Thread bob     = new Person(account, 10);  bob.setName("bob");
        Thread company = new Company(account, 10); company.setName("company");

        alice.start();
        bob.start();
        company.start();
    }
}