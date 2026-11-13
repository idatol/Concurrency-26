public class BadPot {

    private int servings = 0;
    private int capacity;

    public BadPot(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void getserving() throws InterruptedException {
        if (servings == 0) {
            ...
        }
        ...
    }

    public synchronized void fillpot() throws InterruptedException {
        if (servings > 0){
            ...
        }
        ...
    }

    public synchronized void print_servings() {
        ...
    }
}
