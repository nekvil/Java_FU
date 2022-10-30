import java.util.*;

public class Main {

    public static void main(String[] args){
        task_1();
//        task_2();
//        task_3();
//        task_4();
//        task_5();
//        task_6();
//        task_7();
//        task_8();
    }

    public static void task_1(){
        System.out.println("\nTASK1\n");

        Integer[][] intArray = {{0, 1, 2, 3, 4}, {4, 5, 6, 7, 8}};

        Iterator2D<Integer> iterator2D = new Iterator2D<>(intArray);

        for (Integer element : iterator2D) {
            System.out.println(element);
        }
    }
    public static void task_2(){
        System.out.println("\nTASK2\n");

        ArrayList<String> times = new ArrayList<>();
        times.add("First");
        times.add("Second");
        times.add("Third");
        times.add("Fourth");

        Iterator<String> iterator_1 = times.iterator();
        Iterator<String> iterator_2 = times.iterator();

        DoubleIterator<String> doubleIterator = new DoubleIterator<>(iterator_1, iterator_2);

        while(doubleIterator.hasNext()) {
            System.out.println(doubleIterator.next());
        }
    }

    public static void task_3(){
        System.out.println("\nTASK3\n");

        ArrayList<String> times = new ArrayList<>();
        times.add("First");
        times.add("Second");
        times.add("Third");

        Iterator<String> iterator_1 = times.iterator();
        Iterator<String> iterator_2 = times.iterator();

        ArrayList<Iterator<String>> itList = new ArrayList<>();
        itList.add(iterator_1);
        itList.add(iterator_2);

        Iterator<Iterator<String>> it = itList.iterator();
        StringIterator stringIterator = new StringIterator(it);

        while(stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
    }

    public static void task_4(){
        System.out.println("\nTASK4\n");

        ArrayList<String> times = new ArrayList<>();
        times.add("One");
        times.add("Two");
        times.add("Three");

        Iterator<String> iterator_1 = times.iterator();
        Iterator<String> iterator_2 = times.iterator();

        ArrayList<Iterator<String>> itList = new ArrayList<>();
        itList.add(iterator_1);
        itList.add(iterator_2);

        Iterator<Iterator<String>> it = itList.iterator();
        FlatStringIterator flatStringIterator = new FlatStringIterator(it);

        while(flatStringIterator.hasNext()) {
            System.out.println(flatStringIterator.next());
        }
    }

    public static void task_5(){
        System.out.println("\nTASK5\n");

        Collection<String> collection = new ArrayList<>();

        collection.add("One");
        collection.add("Two");
        collection.add("Two");
        collection.add("Two");
        collection.add("Three");

        System.out.println(collection);
        Collection<String> uniqueCollection = UniqueCollection.removeDuplicates(collection);
        System.out.println(uniqueCollection);

    }

    public static void task_6(){
        System.out.println("\nTASK6\n");
        ListsComparison.compare();
    }

    public static void task_7(){
        System.out.println("\nTASK7\n");
        FrequencyVocabulary.init();
    }

    public static void task_8(){
        System.out.println("\nTASK8");

        ATM atm = new ATM();
        Validator validator = new Validator();
        App app = new App();

        SocialCard socialCard = new SocialCard();
        SchoolCard schoolCard = new SchoolCard();
        StudentCard studentCard = new StudentCard();

        // Покупка поездок и счёта по социальной карте через банкомат и приложение
        atm.initRideAdd(socialCard, 1000.0f);
        app.initMoneyAdd(socialCard, 500);
        // Прохождение через валидатор
        validator.initCard(socialCard);
        validator.initCard(socialCard);

        // Пополнение счёта по школьной карте через банкомат
        atm.initMoneyAdd(schoolCard, 1000.0f);
        // Прохождение через валидатор
        validator.initCard(schoolCard);
        validator.initCard(schoolCard);

        // Покупка подписки по студенческой карте через банкомат
        atm.initSubOperation(studentCard, 300);
        // Прохождение через валидатор
        validator.initCard(studentCard);
        validator.initCard(studentCard);

        // Статистика валидатора
        validator.getGlobalStatistic();
    }
}
