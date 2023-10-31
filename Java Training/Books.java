import java.util.Scanner;

class Book {
    private int bookNo;
    private String title;
    private String author;
    private float price;

    // Static member to keep track of the number of books
    private static int bookCount;

    // Static block to initialize bookCount to zero
    static {
        bookCount = 0;
    }

    // Constructor with validations
    public Book(int bookNo, String title, String author, float price) {
        // Validate the title
        if (title.length() < 4) {
            throw new IllegalArgumentException("Title must have at least 4 characters.");
        }

        // Validate the price range
        if (price < 1 || price > 5000) {
            throw new IllegalArgumentException("Price must be in the range 1 to 5000.");
        }

        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.price = price;

        // Increment bookCount when a new Book object is created
        bookCount++;
    }

    // Getter and Setter methods for all instance variables
    public int getBookNo() {
        return bookNo;
    }

    public void setBookNo(int bookNo) {
        this.bookNo = bookNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Static method to get the bookCount
    public static int getBookCount() {
        return bookCount;
    }

    // Override toString() method to print book details
    @Override
    public String toString() {
        return "Book Number: " + bookNo + "\nTitle: " + title + "\nAuthor: " + author + "\nPrice: $" + price;
    }
}

class EngineeringBook extends Book {
    private String category;

    // Constructor for EngineeringBook
    public EngineeringBook(int bookNo, String title, String author, float price, String category) {
        super(bookNo, title, author, price);
        this.category = category;
    }

    // Getter and Setter methods for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Override toString() method to include category
    @Override
    public String toString() {
        return super.toString() + "\nCategory: " + category;
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of 3 Book objects
        Book[] books = new Book[3];

        // Initialize the array of books using user input
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");
            System.out.print("Book Number: ");
            int bookNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Price: $");
            float price = scanner.nextFloat();
            scanner.nextLine(); // Consume newline

            books[i] = new Book(bookNo, title, author, price);
        }

        // Print the book details
        for (Book book : books) {
            System.out.println("\nBook Details:");
            System.out.println(book.toString());
        }

        // Search for a book by book number
        System.out.print("\nEnter the book number to search: ");
        int searchBookNo = scanner.nextInt();

        // Check if the book exists and print its details or an error message
        boolean bookFound = false;
        for (Book book : books) {
            if (book.getBookNo() == searchBookNo) {
                System.out.println("\nBook Found!\n");
                System.out.println(book.toString());
                bookFound = true;
                break;
            }
        }

        if (!bookFound) {
            System.out.println("Book not found. Please enter a valid book number.");
        }

        // Print the total number of books
        System.out.println("\nTotal number of books: " + Book.getBookCount());

        scanner.close();
    }
}
