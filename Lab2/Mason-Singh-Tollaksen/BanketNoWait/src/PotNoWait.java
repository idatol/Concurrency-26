public class PotNoWait {

    private int servings = 0;
    private int capacity;

    public PotNoWait(int capacity) {
        this.capacity = capacity;
    }

    // true = got a serving, false = pot empty, go walk
    public synchronized boolean getserving() {
        if (servings == 0) {
            System.out.println(Thread.currentThread().getName() + " go walk");
            return false;
        }
        else {
            --servings;
            System.out.println(Thread.currentThread().getName() + " is served");
            print_servings();
            return true;
        }
    }

    // true = pot filled, false = pot not empty, go walk
    public synchronized boolean fillpot() {
        if (servings > 0) {
            System.out.println(Thread.currentThread().getName() + " go walk");
            return false;
        }
        else {
            servings = capacity;
            System.out.println(Thread.currentThread().getName() + " fills the pot");
            print_servings();
            return true;
        }
    }

    public synchronized void print_servings() {
        System.out.println("servings in the pot: " + servings);
    }
}
