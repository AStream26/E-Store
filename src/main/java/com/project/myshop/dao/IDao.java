package com.project.myshop.dao;

import com.project.myshop.enums.Status;
import com.project.myshop.helper.SessionFactoryProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public interface IDao<Model> {

    default Status save(Model model) {

        Transaction transaction = null;
        SessionFactory factory = null;
        Session session = null;
        boolean flag = false;
        try {
            factory = SessionFactoryProvider.getSessionFactory();
            session = factory.openSession();
            transaction = session.beginTransaction();

            session.persist(model);
            flag = true;
        } catch (Exception exp) {

            throw exp;
        } finally {

            if (flag) {
                transaction.commit();
            } else {
                transaction.rollback();
            }

            SessionFactoryProvider.closeSession(factory, session);
        }

        return Status.SUCCESS;
    }

    default Model findById(Class<Model> inputClass, Integer id) {

        SessionFactory factory = null;
        Session session = null;
        Model model = null;
        try {

            factory = SessionFactoryProvider.getSessionFactory();
            session = factory.openSession();

            model = session.get(inputClass, id);
        } catch (Exception exp) {
            System.err.println("Error = " + exp.getMessage());
        }

        return model;
    }

    Status updateById(Object obj);

    Status deleteById(Object obj);

    default List<Model> findAll(Class<Model> inputClass) {

        SessionFactory factory = null;
        Session session = null;
        List<Model> list = null;
        try {
            factory = SessionFactoryProvider.getSessionFactory();
            session = factory.openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Model> criteriaQuery = builder.createQuery(inputClass);
            Root<Model> root = criteriaQuery.from(inputClass);
            criteriaQuery.select(root);
            list = session.createQuery(criteriaQuery).getResultList();

        } catch (Exception exp) {
            System.err.println("Error = " + exp.getMessage());
        }

        return list;

    }
    
    default List<Model> find(String queryCondition,String queryValue,Class<Model> inputClass){
        SessionFactory factory = null;
        Session session = null;
        List<Model> list = null;
        System.out.println("******************" +queryCondition + " " + queryValue );
        try {
            factory = SessionFactoryProvider.getSessionFactory();
            session = factory.openSession();

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Model> criteriaQuery = builder.createQuery(inputClass);
            Root<Model> root = criteriaQuery.from(inputClass);
            Predicate condition = builder.equal(root.get(queryCondition), queryValue);
            criteriaQuery.where(condition);
            criteriaQuery.select(root);
            list = session.createQuery(criteriaQuery).getResultList();
            System.out.println("*--------------" +queryCondition + " " + queryValue );

        } catch (Exception exp) {
            System.err.println("Error = " + exp.getMessage());
        }

        return list;
    }
;
}
