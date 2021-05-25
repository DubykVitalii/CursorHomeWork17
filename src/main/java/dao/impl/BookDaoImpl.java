package dao.impl;

import dao.Dao;
import model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import util.HibernateSessionFactoryUtil;

import java.util.List;

@Repository
public class BookDaoImpl implements Dao<Book> {

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
        List<Book> books =  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Book", Book.class).list();
        return books;
    }

}
