package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    private List<Author> authors;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
        this.authors = new ArrayList<>();
    }

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addAuthor(Author author) {
        author.setBook(this);
        authors.add(author);
    }

    public void removeAuthor(Author author) {
        author.setBook(null);
        authors.remove(author);
    }

    @Override
    public String toString() {
        return name +" "+ authors;
    }
}
