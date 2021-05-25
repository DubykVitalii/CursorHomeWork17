package dao.impl;

import dao.Dao;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import util.HibernateSessionFactoryUtil;

import java.util.List;

@Repository
public class UserDaoImlp implements Dao<User> {

    public UserDaoImlp() {
    }

    @Override
    public User findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        session.close();
    }

    @Override
    public List<User> findAll() {
        List<User> users = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From User", User.class).list();
        return users;
    }


}
