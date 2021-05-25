import model.Author;
import model.Book;
import model.User;
import sevice.LibraryService;

public class Main {
    public static void main(String[] args) {
        /**
         * Create users
         * */
        User user1 = new User("Ivan");
        User user2 = new User("Oleg");
        User user3 = new User("Petr");

        /**
         * Create books
         * */
        Book book = new Book("War 1942");
        Book book1 = new Book("The Great Gatsby ");
        Book book2 = new Book("The Adventures of Huckleberry Finn");
        Book book3 = new Book("The end");
        /**
         * Create authors
         * */
        Author author = new Author("Anton Chekhov");
        Author author1 = new Author("Mark Twain");
        Author author2 = new Author("George Eliot");
        Author author3 = new Author("John Li");

        /**
         * Add authors -> books
         * */
        book.addAuthor(author);
        book1.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author3);

        /**
         *
         * Add books -> users
         * */
        user1.addBook(book);
        user1.addBook(book1);
        user2.addBook(book2);
        user3.addBook(book3);

        /**
         * Save entity
         * */
        LibraryService.getEntity().saveAuthor(author);
        LibraryService.getEntity().saveAuthor(author1);
        LibraryService.getEntity().saveAuthor(author2);
        LibraryService.getEntity().saveAuthor(author3);
        LibraryService.getEntity().saveUser(user1);
        LibraryService.getEntity().saveUser(user2);
        LibraryService.getEntity().saveUser(user3);

        /**
         * Show
         * */
        System.out.println("All books user");
        user1.getBooks().stream().forEach(System.out::println);

        System.out.println("All books library");
        LibraryService.getEntity().findAllBook().stream().forEach(System.out::println);

        System.out.println("All users");
        LibraryService.getEntity().findAllUser().stream().forEach(System.out::println);

        System.out.println("Book by id");
        System.out.println(LibraryService.getEntity().findByIdBook(2));
    }
}
