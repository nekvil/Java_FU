public class Book {

    private final String bookName;
    private final String authorName;

    public Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;

    }

    public String getInfo(){
        return "'" + this.bookName + "'" + " - " + this.authorName;
    }
}
