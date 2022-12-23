import java.util.Random;

public class Philosopher implements Runnable {
    private final Random random;
    private final Fork fork_1;
    private final Fork fork_2;

    public Philosopher(Fork fork_1, Fork fork_2) {
        random = new Random();
        this.fork_1 = fork_1;
        this.fork_2 = fork_2;
    }

    private void eat() {
        fork_1.take();
        fork_2.take();
        try {
            System.out.println(Thread.currentThread().getName() + " ест");
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() {
        fork_1.drop();
        fork_2.drop();
        try {
            System.out.println(Thread.currentThread().getName() + " философствует");
            Thread.sleep(random.nextInt(1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        while (true) {
            eat();
            think();
        }
    }
}