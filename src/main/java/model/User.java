package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName (String name){
            this.name = name;
        }

     public void addBook(Book book, User user) {

     }

    public void addBook(Book book) {
        book.setUser(this);
        books.add(book);
    }

    public void removeBook(Book book) {
        book.setUser(null);
        books.remove(book);
    }

    @Override
    public String toString() {
        return "User:" +
                "id=" + id +
                ", name='" + name;
    }
}

