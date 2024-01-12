package com.project.myshop.dao;

import com.project.myshop.enums.Status;
import com.project.myshop.helper.SessionFactoryProvider;
import com.project.myshop.model.User;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao implements IDao<User> {

    private Session session = null;

    public User getUserByEmail(String email) {

        Transaction transaction = null;
        SessionFactory factory = null;
        User user = null;
        try {
            factory = SessionFactoryProvider.getSessionFactory();
            session = factory.openSession();

            Query query = session.createQuery("FROM User WHERE email =:email", User.class);
            query.setParameter("email", email);
            List<User> userList = query.getResultList();

            if (userList.size() != 0) {
                user = userList.get(0);
            }

        } catch (Exception exp) {
            exp.printStackTrace();

        } finally {

            SessionFactoryProvider.closeSession(factory, session);
        }
        return user;
    }

    public Status updateById(Object user) {
        return null;
    }

    public Status deleteById(Object user) {
        return null;
    }
}
