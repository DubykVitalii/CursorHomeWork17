package dao.impl;

import dao.Dao;
import model.Author;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class AuthorDaoImpl implements Dao<Author> {

    @Autowired
    public AuthorDaoImpl() {
    }

    @Override
    public Author findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Author.class, id);
    }

    @Override
    public void save(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(author);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(author);
        tx.commit();
        session.close();
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = (List<Author>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User", Author.class).list();
        return authors;
    }
}
