package BadBanketOne;

public class BadPot {

	private int servings = 0;
	private int capacity;

	public BadPot(int capacity) {
			this.capacity = capacity;
		}

	public synchronized void getserving() throws InterruptedException {
		// Condition synchronization: at least one serving available,
		// otherwise, go to the Wait Set til the cook fill the pot
		if (servings == 0) {
			System.out.println(Thread.currentThread().getName() + " has to wait");
			wait();
		}
		--servings;
		System.out.println(Thread.currentThread().getName() + " is served");
		// when necessary, wake up threads in Wait Set in order to asure
		// a runnable cook
		if (servings == 0)
			notifyAll();
		print_servings();
	}

	public synchronized void fillpot() throws InterruptedException {
		// Condition synchronization: pot is empty
		// go to wait set until pot is empty
		if (servings > 0) {
			System.out.println(Thread.currentThread().getName() + " has to wait");
			wait();
		}
		servings = capacity;
		System.out.println(Thread.currentThread().getName() + " fills the pot");
		// wake up threads in Wait Set in order to asure....
		print_servings();
		notifyAll();
	}

	// only for trace purposes
	public synchronized void print_servings() {
		System.out.println("servings in the pot: " + servings);
	}
}
