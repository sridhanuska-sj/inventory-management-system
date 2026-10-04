import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application for the Library Management System.
 *
 * This class provides a menu-driven command-line interface
 * for performing CRUD operations on books.
 *
 * CRUD:
 * C - Create (Add Book)
 * R - Read   (List Books)
 * U - Update (Update Book)
 * D - Delete (Delete Book)
 *
 * Books are stored in memory using an ArrayList.
 */
public class LibraryApp {

    // ArrayList is used to store books in memory.
    private static final ArrayList<Book> books = new ArrayList<>();

    // Scanner is used to read user input from the console.
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Main method - application starts here.
     */
    public static void main(String[] args) {

        boolean running = true;

        System.out.println("======================================");
        System.out.println("      LIBRARY MANAGEMENT SYSTEM");
        System.out.println("======================================");

        while (running) {

            displayMenu();

            int choice = readInteger("Enter your choice: ");

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    listBooks();
                    break;

                case 3:
                    updateBook();
                    break;

                case 4:
                    deleteBook();
                    break;

                case 5:
                    running = false;
                    System.out.println("\nThank you for using the Library Management System!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please select an option from 1 to 5.");
            }
        }

        scanner.close();
    }

    /**
     * Displays the main menu.
     */
    private static void displayMenu() {

        System.out.println("\n--------------------------------------");
        System.out.println("              MAIN MENU");
        System.out.println("--------------------------------------");
        System.out.println("1. Add Book");
        System.out.println("2. List All Books");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Exit");
        System.out.println("--------------------------------------");
    }

    /**
     * Adds a new book to the library.
     */
    private static void addBook() {

        System.out.println("\n========== ADD BOOK ==========");

        String title = readNonEmptyString("Enter book title: ");
        String author = readNonEmptyString("Enter author name: ");
        String isbn = readNonEmptyString("Enter ISBN: ");

        // Check whether ISBN already exists.
        if (findBookByIsbn(isbn) != null) {
            System.out.println("A book with this ISBN already exists.");
            return;
        }

        int publicationYear = readPositiveInteger(
                "Enter publication year: "
        );

        Book book = new Book(
                title,
                author,
                isbn,
                publicationYear
        );

        books.add(book);

        System.out.println("\nBook added successfully!");
    }

    /**
     * Displays all books currently stored in the library.
     */
    private static void listBooks() {

        System.out.println("\n========== BOOK LIST ==========");

        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        for (int i = 0; i < books.size(); i++) {

            System.out.println("\nBook #" + (i + 1));
            System.out.println("------------------------------");
            System.out.println(books.get(i));
        }

        System.out.println("\nTotal books: " + books.size());
    }

    /**
     * Updates the details of an existing book.
     *
     * ISBN is used to identify the book.
     */
    private static void updateBook() {

        System.out.println("\n========== UPDATE BOOK ==========");

        String isbn = readNonEmptyString(
                "Enter ISBN of the book to update: "
        );

        Book book = findBookByIsbn(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("\nCurrent book details:");
        System.out.println("------------------------------");
        System.out.println(book);

        System.out.println("\nEnter new details:");

        String newTitle = readNonEmptyString("Enter new title: ");
        String newAuthor = readNonEmptyString("Enter new author: ");
        int newPublicationYear = readPositiveInteger(
                "Enter new publication year: "
        );

        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        book.setPublicationYear(newPublicationYear);

        System.out.println("\nBook updated successfully!");
    }

    /**
     * Deletes an existing book from the library.
     *
     * ISBN is used to identify the book.
     */
    private static void deleteBook() {

        System.out.println("\n========== DELETE BOOK ==========");

        String isbn = readNonEmptyString(
                "Enter ISBN of the book to delete: "
        );

        Book book = findBookByIsbn(isbn);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("\nBook found:");
        System.out.println("------------------------------");
        System.out.println(book);

        System.out.print("\nAre you sure you want to delete this book? (Y/N): ");

        String confirmation = scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("Y")) {

            books.remove(book);

            System.out.println("Book deleted successfully!");

        } else {

            System.out.println("Delete operation cancelled.");
        }
    }

    /**
     * Searches for a book using its ISBN.
     *
     * @param isbn ISBN to search for
     * @return matching Book object or null if not found
     */
    private static Book findBookByIsbn(String isbn) {

        for (Book book : books) {

            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }

        return null;
    }

    /**
     * Reads a non-empty String from the user.
     *
     * @param message message displayed to the user
     * @return valid String entered by the user
     */
    private static String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }

    /**
     * Reads a valid integer from the user.
     *
     * Exception handling is used to prevent the application
     * from crashing when the user enters invalid data.
     *
     * @param message message displayed to the user
     * @return valid integer
     */
    private static int readInteger(String message) {

        while (true) {

            System.out.print(message);

            try {

                int value = Integer.parseInt(
                        scanner.nextLine().trim()
                );

                return value;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }

    /**
     * Reads a positive integer from the user.
     *
     * @param message message displayed to the user
     * @return positive integer
     */
    private static int readPositiveInteger(String message) {

        while (true) {

            int value = readInteger(message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Please enter a positive number."
            );
        }
    }
}