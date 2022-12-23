import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static ArrayList<Task> tasks = new ArrayList<Task>();
    public static Scanner scanner = new Scanner(System.in);
    public static int option;

    private static final String[] mainMenuOptions = {
            "1 - Create",
            "2 - List",
            "3 - Exit",
    };

    private static final String[] createTaskOptions = {
            "1 - Set title ",
            "2 - Set description",
            "3 - Set end date",
            "4 - Save",
            "5 - Back",
    };

    private static final String[] byDateOptions = {
            "1 - Skip",
            "2 - By end date",
            "3 - By start date",
            "4 - Back",
    };

    private static final String[] byCompleteOptions = {
            "1 - All",
            "2 - Completed",
            "3 - Not completed",
            "4 - Back",
    };
    private static final String[] taskOptions = {
            "1 - Edit",
            "2 - Delete",
            "3 - Back",
    };

    private static final String[] editTaskOptions = {
            "1 - Change title ",
            "2 - Change description",
            "3 - Change start date",
            "4 - Change end date",
            "5 - Close task",
            "6 - Open task",
            "7 - Back",
    };
    public static void printMenu(String[] options, String menuTitle){
        System.out.println("\n"+menuTitle);
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("\n"+"Enter: ");
    }
    public static void main(String[] args) {
        option = 1;
        while (true){
            printMenu(mainMenuOptions, "Main");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> createTaskMenu();
                    case 2 -> byDateMenu();
                    case 3 -> exit(0);
                }
            }
            catch (Exception ex){
                System.out.println("\n"+"Please enter an integer value between 1 and " + mainMenuOptions.length);
                scanner.next();
            }
        }
    }

    public static void createTaskMenu() {
        option = 1;
        Task task = new Task();
        while (true){
            printMenu(createTaskOptions, "Create new task");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.print("Enter title: ");
                        task.setTitle(new Scanner(System.in).nextLine());
                    }
                    case 2 -> {
                        System.out.print("Enter description: ");
                        task.setDescription(new Scanner(System.in).nextLine());
                    }
                    case 3 -> {
                        System.out.print("Enter end date: ");
                        task.setEndDate(new Scanner(System.in).nextLine());
                    }
                    case 4 -> {
                        tasks.add(task);
                        return;
                    }
                    case 5 -> {
                        return;}
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + createTaskOptions.length);
                scanner.next();
            }
        }
    }

    public static void byDateMenu() {
        option = 1;
        while (true){
            printMenu(byDateOptions, "Filter by date");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        byCompleteMenu(1, "");
                    }
                    case 2 -> {
                        System.out.print("Enter end date: ");
                        byCompleteMenu(2, new Scanner(System.in).nextLine());
                    }
                    case 3 -> {
                        System.out.print("Enter start date: ");
                        byCompleteMenu(3, new Scanner(System.in).nextLine());
                    }
                    case 4 -> {
                        return;
                    }
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + byDateOptions.length);
                scanner.next();
            }
        }
    }

    public static void byCompleteMenu(int dateMode, String date) {
        option = 1;
        while (true){
            switch (dateMode) {
                case 1 -> {
                    printMenu(byCompleteOptions, "No filter");
                }
                case 2 -> {
                    printMenu(byCompleteOptions, "Filter by end date - "+date);
                }
                case 3 -> {
                    printMenu(byCompleteOptions, "Filter by start date - "+date);
                }
            }
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        showTaskList(1, dateMode, date);
                    }
                    case 2 -> {
                        showTaskList(2, dateMode, date);
                    }
                    case 3 -> {
                        showTaskList(3, dateMode, date);
                    }
                    case 4 -> {
                        return;
                    }
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + byCompleteOptions.length);
                scanner.next();
            }
        }
    }

    public static void showTaskList(int completeMode, int dateMode, String date) {
        option = 1;
        while (true){
            int listSize = 0;
            int i = 0;

            System.out.println("\n"+"Task list");
            for (Task task : tasks) {
                i += 1;
                switch (completeMode) {
                    case 1 -> {
                        switch (dateMode) {
                            case 1 -> {
                                System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                listSize += 1;
                            }
                            case 2 -> {
                                if (Objects.equals(task.endDate, date)){
                                    System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                    listSize += 1;
                                }
                            }
                            case 3 -> {
                                if (Objects.equals(task.startDate, date)){
                                    System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                    listSize += 1;
                                }
                            }
                        }
                    }
                    case 2 -> {
                        switch (dateMode) {
                            case 1 -> {
                                if (task.isComplete){
                                    System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                    listSize += 1;}
                            }
                            case 2 -> {
                                if (Objects.equals(task.endDate, date)){
                                    if (task.isComplete){
                                        System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                        listSize += 1;}
                                }
                            }
                            case 3 -> {
                                if (Objects.equals(task.startDate, date)){
                                    if (task.isComplete){
                                        System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                        listSize += 1;}
                                }
                            }
                        }
                    }
                    case 3 -> {
                        switch (dateMode) {
                            case 1 -> {
                                if (!task.isComplete){
                                    System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                    listSize += 1;}
                            }
                            case 2 -> {
                                if (Objects.equals(task.endDate, date)){
                                    if (!task.isComplete){
                                        System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                        listSize += 1;}
                                }
                            }
                            case 3 -> {
                                if (Objects.equals(task.startDate, date)){
                                    if (!task.isComplete){
                                        System.out.println(i+". "+task.getTitle()+" "+task.getStartDate()+"-"+task.getEndDate());
                                        listSize += 1;}
                                }
                            }
                        }
                    }
                    case 4 -> {
                        return;
                    }
                }

            }

            int backOption = listSize+1;
            System.out.println(backOption+". Back");
            System.out.print("\n"+"Enter: ");

            try {
                option = scanner.nextInt();
                if (option==backOption){
                    return;
                }else{
                    try {
                        Task myTask = tasks.get(option-1);
                        taskMenu(myTask);
                    }
                    catch (Exception ex){
                        System.out.println("\nObject does not exist");
                    }
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + backOption);
                scanner.next();
            }
        }
    }

    public static void taskMenu(Task myTask) {
        option = 1;
        while (true){
            System.out.println("\nDetails");
            System.out.println("id: "+myTask.getId());
            System.out.println("title: "+myTask.getTitle());
            System.out.println("description: "+myTask.getDescription());
            System.out.println("start: "+myTask.getStartDate());
            System.out.println("end: "+myTask.getEndDate());
            System.out.println("completed: "+myTask.isComplete);
            printMenu(taskOptions, "Edit menu");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        editTaskMenu(myTask);
                    }
                    case 2 -> {
                        tasks.remove(myTask);
                        return;
                    }
                    case 3 -> {
                        return;
                    }
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + byDateOptions.length);
                scanner.next();
            }
        }
    }

    public static void editTaskMenu(Task myTask) {
        option = 1;
        while (true){
            printMenu(editTaskOptions, "Edit task");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> {
                        System.out.println("Current title: "+myTask.getTitle());
                        System.out.print("Enter new title: ");
                        myTask.setTitle(new Scanner(System.in).next());
                    }
                    case 2 -> {
                        System.out.println("Current description: "+myTask.getDescription());
                        System.out.print("Enter new description: ");
                        myTask.setDescription(new Scanner(System.in).next());
                    }
                    case 3 -> {
                        System.out.println("Current start date: "+myTask.getStartDate());
                        System.out.print("Enter new start date: ");
                        myTask.setStartDate(new Scanner(System.in).next());
                    }
                    case 4 -> {
                        System.out.println("Current end date: "+myTask.getEndDate());
                        System.out.print("Enter new end date: ");
                        myTask.setEndDate(new Scanner(System.in).next());
                    }
                    case 5 -> {
                        myTask.isComplete = true;
                    }
                    case 6 -> {
                        myTask.isComplete = false;
                    }
                    case 7 -> {
                        return;}
                }
            }
            catch (Exception ex){
                System.out.println("Please enter an integer value between 1 and " + createTaskOptions.length);
                scanner.next();
            }
        }
    }
}
