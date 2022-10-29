public class Ford extends Car{
    private int bassLevel;

    public Ford() {
        this.modelName = "Ford Mustang";
        this.bodyColor = "Blue";
        this.maxSpeed = 200;
        this.currentSpeed = 0;
        this.gearbox = "Mechanic";
        this.currentPrice = 5000000;
        this.bassLevel = 0;
    }

    public Ford(int currentPrice) {
        this.modelName = "Ford Mustang";
        this.bodyColor = "Blue";
        this.maxSpeed = 200;
        this.currentSpeed = 0;
        this.gearbox = "Mechanic";
        this.currentPrice = currentPrice;
        this.bassLevel = 0;
    }


    @Override
    public void start() {
        this.currentSpeed = 10;
    }

    @Override
    public void stop() {
        this.currentSpeed = 0;
    }

    @Override
    public void accelerate(int speed) {
        this.currentSpeed += speed;
    }

    public void incEngineBass(){
        this.bassLevel += 10;
    }

    public void decEngineBass(){
        this.bassLevel -= 10;
    }

}
