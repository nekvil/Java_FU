import java.util.Arrays;

abstract class TransportCard{

    private float balance;
    private int rides;
    private final int[] subDate = new int[3];

    private boolean subDateStatus;

    public void incCard(float incBalance) {
        this.balance += incBalance;
    }

    public void decCard(float decBalance) {
        this.balance -= decBalance;
    }

    public void incCard(int incRides) {
        this.rides += incRides;
    }

    public void decCard(int decRides) {
        this.rides -= decRides;
    }

    public float getBalance() {
        return this.balance;
    }

    public int getRides() {
        return this.rides;
    }

    public int[] getSubDate() {
        return this.subDate;
    }

    public boolean getSubStatus(){
        return this.subDateStatus;
    }

    public void initBuyingSubscription(int[] subscriptionDate) {
        System.arraycopy(subscriptionDate, 0, this.subDate, 0, 3);
    }


}
