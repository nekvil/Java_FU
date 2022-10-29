public class Reader {
    private final String fullName;
    private Integer ticketNumber;
    private String department;
    private String dateOfBirth;
    private String phoneNumber;


    public Reader(String fullName, Integer ticketNumber, String department, String dateOfBirth, String phoneNumber) {
        this.fullName = fullName;
        this.ticketNumber = ticketNumber;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public void takeBook(int bookCount){
        System.out.println(this.fullName + " взял(а) " + bookCount + " книг(и) ");
    }

    public void takeBook(String[] args){
        System.out.println(this.fullName + " взял(а) книги: " + String.join(", ", args));
    }

    public void takeBook(Book[] obj){
        String[] args = new String[obj.length];
        for (int j = 0; j < obj.length; j++) {
            args[j] = obj[j].getInfo();
        }
        System.out.println(this.fullName + " взял(а) книги: " + String.join(", ", args));
    }

    public void returnBook(int bookCount){
        System.out.println(this.fullName + " вернул(а) " + bookCount + " книг(и) ");
    }

    public void returnBook(String[] args){
        System.out.println(this.fullName + " вернул(а) книги: " + String.join(", ", args));
    }

    public void returnBook(Book[] obj){
        String[] args = new String[obj.length];
        for (int j = 0; j < obj.length; j++) {
            args[j] = obj[j].getInfo();
        }
        System.out.println(this.fullName + " вернул(а) книги: " + String.join(", ", args));
    }

}
