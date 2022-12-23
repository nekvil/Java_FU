public class Root {
    private static double function(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double find(double start, double end){
        if(Math.abs(function(start)- function(end)) <= 0.001){
            return start;
        }

        double x = start + (end - start) / 2;
        if(x == end || x == start){
            return x;
        }

        if(function(start) * function(x) > 0){
            return find(x, end);
        } else {
            return find(start, x);
        }
    }
}
