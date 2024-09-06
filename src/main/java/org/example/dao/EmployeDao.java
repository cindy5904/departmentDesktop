package org.example.dao;

import org.example.model.Employe;
import org.example.util.ConnexionDb;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeDao {
    public void addEmployee(Employe employe) {
        Transaction transaction = null;
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employe> getAllEmployes() {
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            return session.createQuery("from Employe", Employe.class).list();
        }
    }

    public void updateEmploye(Employe employe) {
        Transaction transaction = null;
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(employe);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteEmploye(Long id) {
        Transaction transaction = null;
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employe employe = session.get(Employe.class, id);
            if (employe != null) {
                session.delete(employe);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
