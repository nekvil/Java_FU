public class Ferrari extends Car{
    private boolean roofStatus;

    public Ferrari() {
        this.modelName = "Ferrari Stradale";
        this.bodyColor = "Red";
        this.maxSpeed = 450;
        this.currentSpeed = 0;
        this.gearbox = "Auto";
        this.currentPrice = 30000000;
        this.roofStatus = true;
    }

    public Ferrari(int currentPrice) {
        this.currentPrice = currentPrice;
        this.modelName = "Ferrari Stradale";
        this.bodyColor = "Red";
        this.maxSpeed = 450;
        this.currentSpeed = 0;
        this.gearbox = "Auto";
        this.roofStatus = true;
    }

    @Override
    public void start() {
        this.currentSpeed = 20;
    }

    @Override
    public void stop() {
        this.currentSpeed = 0;
    }

    @Override
    public void accelerate(int speed) {
        this.currentSpeed += speed;
    }

    public void roofTakeOff(){
        this.roofStatus = false;
    }
    public void roofGetOn(){
        this.roofStatus = true;
    }

}
