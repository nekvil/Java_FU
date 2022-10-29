import java.util.ArrayList;

public class Garage {
    private final int maxCap;
    private int fordCount;
    private int ferrariCount;

    private final ArrayList<Car> carArrayList = new ArrayList<>();

    public Garage(int maxCap) {
        this.maxCap = maxCap;
    }

    public void addCar(Ferrari ferrari) {
        if (carArrayList.size() < maxCap){
            this.carArrayList.add(ferrari);
            this.ferrariCount += 1;
        }else{
            System.out.println("В гараже нет места");
        }

    }

    public void addCar(Ford ford) {
        if (carArrayList.size() < maxCap){
            this.carArrayList.add(ford);
            this.fordCount += 1;
        }
        else{
            System.out.println("В гараже нет места");
        }
    }

    public void getCars() {
        carArrayList.sort(new MyComp());

        for (Car car:carArrayList) {
            System.out.println("Автомобиль "+car.modelName +" за "+ car.currentPrice);
        }
        System.out.println("\nВсего машин марки Ford: "+fordCount);
        System.out.println("Всего машин марки Ferrari: "+ferrariCount);
    }

}


