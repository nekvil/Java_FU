import java.util.Arrays;
import java.util.Random;

public class Matrix {
    double[][] data;
    int rows, cols;

    public Matrix(int rows, int cols, boolean nullable) {
        data = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        if (nullable)
            this.zero();
    }
    public Matrix(int rows, int cols) {
        data = new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        this.randomMat();
    }

    private void zero() {
        for (double[] datum : data) {
            Arrays.fill(datum, 0);
        }
    }

    private void randomMat() {
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = random.nextInt(0, 10);
            }
        }
    }

    private boolean isSquare() {
        return rows == cols;
    }

    public void display() {
        System.out.print("\n[");
        for (int row = 0; row < rows; ++row) {
            if (row != 0) {
                System.out.print(" ");
            }

            System.out.print("[");

            for (int col = 0; col < cols; ++col) {
                System.out.printf("%8.2f", data[row][col]);

                if (col != cols - 1) {
                    System.out.print(" ");
                }
            }

            System.out.print("]");

            if (row == rows - 1) {
                System.out.print("]");
            }

            System.out.println();
        }
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);

        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                result.data[col][row] = data[row][col];
            }
        }

        return result;
    }

    public Matrix multiply(double value) {
        Matrix result = new Matrix(rows, cols);
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                result.data[row][col] = data[row][col] * value;
            }
        }

        return result;
    }

    public Matrix exponent(double value) {
        if (!isSquare()){
            System.out.println("\nМатрица не квадратная!");
            return new Matrix(1, 1, true);
        }else {
            Matrix result = this;

            int i = 1;
            while (i < value) {
                result = result.composition(this);
                i++;
            }

            return result;
        }
    }

    public Matrix addition(Matrix second_matrix) {
        if ((rows != second_matrix.rows) || (cols != second_matrix.cols)) {
            System.out.println("\nРазмер матриц не верен!");
            return new Matrix(1, 1, true);
        } else {
            Matrix result = new Matrix(second_matrix.rows, cols);
            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    result.data[row][col] = data[row][col] + second_matrix.data[row][col];
                }
            }
            return result;
        }
    }

    public Matrix difference(Matrix second_matrix) {
        if ((rows != second_matrix.rows) || (cols != second_matrix.cols)) {
            System.out.println("\nРазмер матриц не верен!");
            return new Matrix(1, 1, true);
        } else {
            Matrix result = new Matrix(second_matrix.rows, cols);
            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    result.data[row][col] = data[row][col] - second_matrix.data[row][col];
                }
            }
            return result;
        }
    }

    public Matrix composition(Matrix second_matrix) {
        if ((cols != second_matrix.rows)) {
            System.out.println("\nКоличество столбцов не равно количеству строк!");
            return new Matrix(1, 1, true);
        } else {
            Matrix result = new Matrix(rows, second_matrix.cols, true);
            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < second_matrix.cols; ++col) {
                    for (int _col = 0; _col < cols; _col++) {
                        result.data[row][col] += data[row][_col] * second_matrix.data[_col][col];
                    }
                }
            }
            return result;
        }
    }

}
