package sevice;

import dao.impl.AuthorDaoImpl;
import dao.impl.BookDaoImpl;
import dao.impl.UserDaoImlp;
import model.Author;
import model.Book;
import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class LibraryService {
    private static LibraryService entity;
    ApplicationContext context = new AnnotationConfigApplicationContext("dao.impl");
    AuthorDaoImpl authorDao = context.getBean(AuthorDaoImpl.class);
    BookDaoImpl bookDao = context.getBean(BookDaoImpl.class);
    UserDaoImlp userDao = context.getBean(UserDaoImlp.class);

    private LibraryService() {
    }

    public static LibraryService getEntity() {
        if (entity == null) {
            entity = new LibraryService();
        }
        return entity;
    }

    /**
     * Service users
     */
    public void saveUser(User user) {
        userDao.save(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public User findByIdUser(int id) {
        return userDao.findById(id);
    }

    public List<User> findAllUser() {
        return userDao.findAll();
    }

    /**
     * Service authors
     */
    public void saveAuthor(Author author) {
        authorDao.save(author);
    }

    public void deleteAuthor(Author author) {
        authorDao.delete(author);
    }

    public void updateAuthor(Author author) {
        authorDao.update(author);
    }

    public Author findByIdAuthor(int id) {
        return authorDao.findById(id);
    }

    public List<Author> findAllAuthor() {
        return authorDao.findAll();
    }

    /**
     * Service books
     */
    public void saveBook(Book book) {
        bookDao.save(book);
    }

    public void deleteBook(Book book) {
        bookDao.save(book);
    }

    public void updateBook(Book book) {
        bookDao.save(book);
    }

    public Book findByIdBook(int id) {
        return bookDao.findById(id);
    }

    public List<Book> findAllBook() {
        return bookDao.findAll();
    }


}
