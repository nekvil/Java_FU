import java.util.ArrayList;
import java.util.LinkedList;

public class ListsComparison {
    public static void compare() {
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();

        final int million = 1000000;
        final int oneHundredThousand = 100000;

        for (int i = 0; i < million; i++) {
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < oneHundredThousand; i++) {
            double result = arrayList.get((int) (Math.random() * (million - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();

        for (int i = 0; i < oneHundredThousand; i++) {
            double result = linkedList.get((int) (Math.random() * (million - 1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
