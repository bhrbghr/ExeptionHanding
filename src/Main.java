public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println(e.getMessage());
        }

        createAndAddBook(library, "Java Programming", 300);
        createAndAddBook(library, "Design Patterns", -3);
        createAndAddBook(library, null, 100);
        createAndAddBook(library, "",400);

        try {
            library.listBooks();
        } catch (EmptyLibraryException e) {
            System.out.println(e.getMessage());
        }

        try {
            library.borrowBook("Java Programming");
        } catch (EmptyLibraryException e) {
            System.out.println(e.getMessage());
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            library.returnBook("Non-existent book");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            library.returnBook("Java Programming");
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createAndAddBook(Library library, String title, int pages) {
        try {
            Book book = new Book(title, pages);
            library.addBook(book);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating book: " + e.getMessage());
        } catch (InvalidBookException e) {
            System.out.println("Error adding book to library: " + e.getMessage());
        }
    }
}
