abstract class Shape {
    private double volume;
    public double getVolume() {
        return this.volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
}

class Box extends Shape {
    public boolean add(Shape shape) {
        if (this.getVolume() < shape.getVolume()) {
            return false;
        } else {
            double freeVolume = this.getVolume() - shape.getVolume();
            this.setVolume(freeVolume);
            return true;
        }
    }
}
abstract class SolidOfRevolution extends Shape {
    private double radius;

    public double getRadius() {
        return radius;
    }
}

class Pyramid extends Shape {
    private double s, h;
}

class Cylinder extends SolidOfRevolution {
    private double height;
}

class Ball extends SolidOfRevolution {

}
