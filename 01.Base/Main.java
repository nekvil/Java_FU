public class Main {
    public static void twentyOne(int number){
        System.out.println("Целочисленное значение: " + (number-21));
    }

    public static void arithmeticMean(int one, int two){
        System.out.println("Среднее арифметическое: " + (one+two)/2);
    }

    public static void geometricMean(int one, int two){
        System.out.println("Среднее геометерическое: " + Math.sqrt(one*two));
    }

    public static void distance(double x_1, double y_1, double x_2, double y_2){
        System.out.println("Расстояние между точками: " + Math.sqrt(Math.pow(x_1 - x_2, 2) + Math.pow(y_1 - y_2, 2)));
    }

    public static void main(String[] args) {
        // 1
        System.out.println("Hello world!");

        // 2
        int x = 1;
        System.out.println("\nЦелочисленное значение: " + x);

        // 3
        int i = 0;
        ++i;
        i = i + 1;
        i++;
        i += 1;
        System.out.println("\n++var: " + i);

        // 4
        int one = 1;
        int two = 2;
        System.out.println("\none = " + one);
        System.out.println("two = " + two);

        one = one + two - (two = one);
        System.out.println("\n1.");
        System.out.println("one = " + one);
        System.out.println("two = " + two);

        one = 1;
        two = 2;
        one = one ^ two;
        two = two ^ one;
        one = one ^ two;
        System.out.println("\n2.");
        System.out.println("one = " + one);
        System.out.println("two = " + two);

        // 5
        int a = 10;
        int b = 20;
        double hyp = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        System.out.println("\nHypotenuse = " + hyp);

        // 6
        int natural = 15245;
        System.out.println("\nlastNat: " + natural%10);

        // 7
        System.out.println("\ntenCount: " + natural/10%10);

        // 8
        int doubleNat = 25;
        System.out.println("\ntenCount: " + doubleNat/10);

        // 9
        System.out.println();
        twentyOne(10);
        twentyOne(50);
        twentyOne(100);

        // 10
        System.out.println();
        arithmeticMean(12, 24);

        // 11
        System.out.println();
        geometricMean(12, 24);

        // 12
        System.out.println();
        distance(2, 4, 6,8);
    }
}
