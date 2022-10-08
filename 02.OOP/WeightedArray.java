public class WeightedArray {
    int[] valuesArray, weightsArray, grades;
    int addWeight;

    public WeightedArray(int[] values, int[] weights) {
        valuesArray = values;
        weightsArray = weights;
        grades = new int[valuesArray.length];

        addWeight = 0;
        for (int j : weightsArray) addWeight += j;

        int g = 0;
        for (int i = 0; i < grades.length; i++) {
            grades[i] = g;
            g += weightsArray[i];
        }
    }

    public int getNumber() {
        int random = (int) (Math.random() * (addWeight - 1));
        int index = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > random)
                break;
            index = i;
        }
        return valuesArray[index];
    }

}
