package Museum;
public class Control {
    int count = 0;
    boolean opened = false;

    public synchronized void arrive() throws InterruptedException {
        while (!opened) wait();
        //update count
        ++count;
        System.out.println(Thread.currentThread().getName() + ": visitor arrives, inside: " + count);
        notifyAll();
    }

    public synchronized void leave() throws InterruptedException {
        while (count <= 0) wait();
        --count;
        System.out.println(Thread.currentThread().getName() + ": visitor leaves, inside: " + count);
        if (count == 0) notifyAll();
    }

    public synchronized void open() throws InterruptedException {
        while (count > 0) wait();
        opened = true;
        System.out.println(Thread.currentThread().getName() + ": museum OPEN");
        notifyAll();
    }

    public synchronized void close() throws InterruptedException {
        opened = false;
        System.out.println(Thread.currentThread().getName() + ": museum CLOSED, inside: " + count);
    }
}
