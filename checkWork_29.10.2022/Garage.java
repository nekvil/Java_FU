import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Garage {
    private int maxCap;
    private int fordCount;
    private int ferrariCount;

    private ArrayList<Car> carArrayList = new ArrayList<>();

    public Garage(int maxCap) {
        this.maxCap = maxCap;
    }

    public void addCar(Ferrari ferrari) {
        if (carArrayList.size() < maxCap){
            this.carArrayList.add(ferrari);
            this.ferrariCount += 1;
        }

    }

    public void addCar(Ford ford) {
        if (carArrayList.size() < maxCap){
            this.carArrayList.add(ford);
            this.fordCount += 1;
        }
    }

    public void getCars() {
        Collections.sort(carArrayList, new MyComp());

        for (Car car:carArrayList) {
            System.out.println("Автомобиль "+car.modelName +" за "+ car.currentPrice);
        }
    }

}


