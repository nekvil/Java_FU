public class linearBinarySearch {
    public static void getResult(int target, int index) {
        System.out.println();
        if (index == -1){
            System.out.println(target + " not found");
        }
        else {
            System.out.println(target + " found at index: " + index);
        }
    }
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target)
                return i;
        }
        return -1;
    }
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, 0, array.length, target);
    }
    private static int binarySearch(int[] array, int low, int high, int target) {
        if (high >= low) {
            int middle = low + (high - low) / 2;
            if (array[middle] == target)
                return middle;
            if (array[middle] > target)
                return binarySearch(array, low, middle - 1, target);
            return binarySearch(array, middle + 1, high, target);
        }
        return -1;
    }
}
