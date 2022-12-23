public class Main {
    public static void task_1(){
        NewThread nT = new NewThread();
        nT.start();
    }

    public static void task_2(){
        for (int i = 1; i <= 3; i++){
            new Thread(new MyThread(), String.valueOf(i)).start();
        }
    }

    public static void task_3(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        StringThread[] stringThreads = new StringThread[]{
                new StringThread(stringBuilder),
                new StringThread(stringBuilder),
                new StringThread(stringBuilder)
        };
        for (StringThread stringThread : stringThreads) {
            stringThread.start();
        }
    }

    public static void task_4(){
        Fork[] forks = new Fork[]{new Fork(), new Fork(), new Fork(), new Fork(), new Fork()};

        Thread thread_1 = new Thread(new Philosopher(forks[4], forks[0]));
        thread_1.setName("Плутарх");
        Thread thread_2 = new Thread(new Philosopher(forks[0], forks[1]));
        thread_2.setName("Аристотель");
        Thread thread_3 = new Thread(new Philosopher(forks[2], forks[1]));
        thread_3.setName("Платон");
        Thread thread_4 = new Thread(new Philosopher(forks[2], forks[3]));
        thread_4.setName("Эпикур");
        Thread thread_5 = new Thread(new Philosopher(forks[4], forks[3]));
        thread_5.setName("Сократ");

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_5.start();
    }

    public static void main(String[] args) {
        task_1();
//        task_2();
//        task_3();
//        task_4();
    }

}