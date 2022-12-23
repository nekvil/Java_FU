public class Recursion {
    public static String recursion(int n) {
        if (n == 1) {
            return "1";
        }
        return recursion(n - 1) + "\n" + n;
    }
}
