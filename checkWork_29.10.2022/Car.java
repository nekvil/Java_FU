abstract class Car {

    protected String modelName;
    protected String bodyColor;
    protected int maxSpeed;
    protected String gearbox;
    protected int currentSpeed;
    protected int currentPrice;

    protected void start() {};
    protected void stop() {};
    protected void accelerate(int speed) {};

    protected int getPrice(){
        return this.currentPrice;
    }
}
