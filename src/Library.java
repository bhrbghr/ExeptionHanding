import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) throws InvalidBookException {
        if (book == null) {
            throw new InvalidBookException("Book should not be null.");
        } else {
            books.add(book);
        }
    }

    private Book findBook(String title) {
        for (Book e : books) {
            if (Objects.equals(e.getTitle(), title)) {
                return e;
            }
        }
        return null;
    }

    public void borrowBook(String title) throws BookNotFoundException, EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty, no books to borrow.");
        }

        Book book = findBook(title);

        if (book == null) {
            throw new BookNotFoundException("Book with title '" + title + "' not found.");
        } else {
            System.out.println(book.toString() + " has been borrowed successfully.");
        }
    }


    public void returnBook(String title) throws BookNotFoundException {
        Book book = findBook(title);

        if (book == null) {
            throw new BookNotFoundException("Cannot return. Book with title '" + title + "' not found.");
        } else {
            System.out.println(book.toString() + " has been returned successfully.");
        }
    }


    public void listBooks() throws EmptyLibraryException {
        if (books.isEmpty()) {
            throw new EmptyLibraryException("Library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book e : books) {
                System.out.println(e.toString());
            }
        }
    }
}
