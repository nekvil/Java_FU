public class StringThread extends Thread {
    private final StringBuilder stringBuilder;

    public StringThread(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void run() {
        synchronized (stringBuilder) {
            for (int i = 0; i < 100; i++) {
                System.out.print(stringBuilder);
            }
            System.out.println();
            char cA = stringBuilder.charAt(0);
            stringBuilder.setCharAt(0, ++cA);
        }
    }
}
