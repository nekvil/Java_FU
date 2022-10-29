public class Main {

    public static void main(String[] args){
        task_1();
        task_2();
    }

    public static void task_1(){
        System.out.println("\nБиблиотека\n");

        Book[] bookArray = new Book[5];
        bookArray[0] = new Book("Война и мир", "Лев Толстой");
        bookArray[1] = new Book("Преступление и наказание", "Фёдор Достоевский");
        bookArray[2] = new Book("Горе от ума", "Грибоедов");
        bookArray[3] = new Book("Обломов", "Гончаров");
        bookArray[4] = new Book("Бесприданница", "Островский");

        Reader[] readerArray = new Reader[5];
        readerArray[0] = new Reader("Fomichev Nikita Sergeevich", 1, "ITAABD",
                "19.08.1999", "89154230048");
        readerArray[1] = new Reader("Ivanov Ivan Ivanovich", 2, "ITAABD",
                "19.01.1989", "89154230047");
        readerArray[2] = new Reader("Petrov Petr Petrovich", 3, "ITAABD",
                "17.08.1979", "89154230046");
        readerArray[3] = new Reader("Oblepihin Semen Semenovich", 4, "ITAABD",
                "19.04.2000", "89154230045");
        readerArray[4] = new Reader("Vinogradov Dmitriy Aleskandrovich", 5, "ITAABD",
                "15.08.2002", "89154230044");

        readerArray[0].takeBook(2);
        readerArray[0].takeBook(new String[]{"Война и мир", "Преступление и наказание"});
        readerArray[0].takeBook(new Book[]{bookArray[0], bookArray[1], bookArray[2]});

        System.out.println();

        readerArray[0].returnBook(2);
        readerArray[0].returnBook(new String[]{"Война и мир", "Преступление и наказание"});
        readerArray[0].returnBook(new Book[]{bookArray[0], bookArray[1], bookArray[2]});
    }

    public static void task_2(){
        System.out.println("\nАвтопарк\n");

        Garage myGarage = new Garage(5);
        myGarage.addCar(new Ferrari(10000000));
        myGarage.addCar(new Ferrari());
        myGarage.addCar(new Ford(3999999));
        myGarage.addCar(new Ford());
        myGarage.addCar(new Ford(350999));

        myGarage.getCars();
    }

}