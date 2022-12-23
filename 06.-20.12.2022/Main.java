import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void task_1(){
        System.out.println(Recursion.recursion(100));
    }

    public static void task_2(){
        Random random = new Random();

        int[] array = new int[100000000];
        int target = random.nextInt(100000000);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100000000);
        }
        Arrays.sort(array);

        long time = System.currentTimeMillis();
        linearBinarySearch.getResult(target, linearBinarySearch.linearSearch(array, target));
        System.out.println("Linear elapsed time: " + Long.toString(System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        linearBinarySearch.getResult(target, linearBinarySearch.binarySearch(array, target));
        System.out.println("Binary elapsed time: " + Long.toString(System.currentTimeMillis() - time));
    }

    public static void task_3(){
        System.out.println("\ncos(x^5 )+ x^4-345.3*x-23 = 0");
        System.out.println("x = " + Root.find(0, 10));
    }

    public static void task_4(){
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(9);
        binaryTree.add(6);
        binaryTree.add(3);
        binaryTree.add(2);

        System.out.println(binaryTree.containsNode(2));
    }

    public static void main(String[] args) {
        task_1();
//        task_2();
//        task_3();
//        task_4();
    }
}