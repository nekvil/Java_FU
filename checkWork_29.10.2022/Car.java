abstract class Car {

    protected String modelName;
    protected String bodyColor;
    protected int maxSpeed;
    protected String gearbox;
    protected int currentSpeed;
    protected int currentPrice;

    public void start() {};
    public void stop() {};
    public void accelerate(int speed) {};

    public int getPrice(){
        return this.currentPrice;
    }
}
