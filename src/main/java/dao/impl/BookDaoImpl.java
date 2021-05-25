package dao.impl;

import dao.Dao;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class BookDaoImpl implements Dao<Book> {
    @Autowired
    public BookDaoImpl() {
    }

    @Override
    public Book findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Book.class, id);
    }

    @Override
    public void save(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(book);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(book);
        tx.commit();
        session.close();
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = (List<Book>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Book", Book.class).list();
        return books;
    }

}
