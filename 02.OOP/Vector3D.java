import java.util.Random;

public class Vector3D {
    int x, y, z;
    public Vector3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void display() {
        System.out.format("\n(%d, %d, %d)%n", x, y, z);
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double dotProduct(Vector3D vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    public Vector3D crossProduct(Vector3D vector) {
        int _x = y * vector.z - z * vector.y;
        int _y = z * vector.x - x * vector.z;
        int _z = x * vector.y - y * vector.x;
        return new Vector3D(_x, _y, _z);
    }

    public double angle(Vector3D vector) {
        return dotProduct(vector) / (Math.abs(vector.length()) * Math.abs(length()));
    }

    public Vector3D addition(Vector3D vector) {
        return new Vector3D(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector3D difference(Vector3D vector) {
        return new Vector3D(x - vector.x, y - vector.y, z - vector.z);
    }

    public static Vector3D[] vecArray(int size) {
        Vector3D[] vArr = new Vector3D[size];
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            vArr[i] = new Vector3D(random.nextInt(100), random.nextInt(100), random.nextInt(100));
        }
        return vArr;
    }

}
