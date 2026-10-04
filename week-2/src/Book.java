/**
 * Represents a book in the library inventory.
 *
 * This class stores the basic information of a book:
 * title, author, ISBN, and publication year.
 */
public class Book {

    private String title;
    private String author;
    private String isbn;
    private int publicationYear;

    /**
     * Creates a new Book object with the given details.
     *
     * @param title book title
     * @param author book author
     * @param isbn unique ISBN number
     * @param publicationYear year the book was published
     */
    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Returns book details in a readable format.
     */
    @Override
    public String toString() {
        return "Title: " + title
                + "\nAuthor: " + author
                + "\nISBN: " + isbn
                + "\nPublication Year: " + publicationYear;
    }
}