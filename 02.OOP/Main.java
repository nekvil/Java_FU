public class Main {

    public static void main(String[] args){
        task_1();
        task_2();
        task_3_4();
        task_5();
    }

    public static void task_1(){
        System.out.println("\nTASK1");

        Matrix first_matrix = new Matrix(4, 4);
        Matrix second_matrix = new Matrix(4, 4);

        // a.	Сложение и вычитание матриц.
        Matrix sum_matrix = first_matrix.addition(second_matrix);
        sum_matrix.display();
        first_matrix.display();
        second_matrix.display();

        Matrix dif_matrix = first_matrix.difference(second_matrix);
        dif_matrix.display();
        first_matrix.display();
        second_matrix.display();

        // b.	Умножение матрицы на число.
        Matrix multi_first_matrix = first_matrix.multiply(2);
        multi_first_matrix.display();
        first_matrix.display();

        // c.	Произведение двух матриц.
        Matrix comp_matrix = first_matrix.composition(second_matrix);
        comp_matrix.display();
        first_matrix.display();
        second_matrix.display();

        // d.   Транспонированная матрица.
        Matrix trans_second_matrix = second_matrix.transpose();
        trans_second_matrix.display();
        second_matrix.display();

        // e.	Возведение матрицы в степень.
        Matrix exp_first_matrix = first_matrix.exponent(4);
        exp_first_matrix.display();
        first_matrix.display();
    }
    public static void task_2(){
        System.out.println("\nTASK2");

        Vector3D first_vec = new Vector3D(3, 4, 5);
        Vector3D second_vec = new Vector3D(6, 7, 8);

        first_vec.display();

        System.out.println("\n"+first_vec.length());

        System.out.println("\n"+first_vec.dotProduct(second_vec));

        Vector3D cross_vec = first_vec.crossProduct(second_vec);
        cross_vec.display();

        System.out.println(first_vec.angle(second_vec));

        Vector3D addition_vec = first_vec.addition(second_vec);
        addition_vec.display();

        Vector3D difference_vec = first_vec.difference(second_vec);
        difference_vec.display();

        int vecArrSize = 5;
        Vector3D[] vecArr = Vector3D.vecArray(vecArrSize);
        for (int i = 0; i < vecArrSize; i++)
            vecArr[i].display();
    }

    public static void task_3_4(){
        System.out.println("\nTASK3-4");

        Box box = new Box();
        box.setVolume(99.99);

        Pyramid pyramid = new Pyramid();
        pyramid.setVolume(20.20);

        Ball ball = new Ball();
        ball.setVolume(30.30);

        System.out.println("\nBox volume: " + box.getVolume());
        System.out.println("Pyramid input: " +  box.add(pyramid));
        System.out.println("Ball input: " +  box.add(ball));
        System.out.println("Box volume: " + box.getVolume());

        Cylinder cylinder = new Cylinder();
        cylinder.setVolume(50.50);
        System.out.println("\nCylinder input: " +  box.add(cylinder));
        System.out.println("Box volume: " + box.getVolume());
    }

    public static void task_5(){
        System.out.println("\nTASK5\n");

        int[] values = {1, 2, 3};
        int[] weights = {1, 2, 10};

        WeightedArray weightedArray = new WeightedArray(values, weights);
        for (int i = 0; i < 15; i++)
            System.out.println("Value from array: "+weightedArray.getNumber());
    }
}
