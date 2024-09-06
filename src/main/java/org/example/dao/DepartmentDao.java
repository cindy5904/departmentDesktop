package org.example.dao;

import org.example.model.Department;
import org.example.util.ConnexionDb;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentDao {
    public void addDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Department> getAllDepartments() {
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            return session.createQuery("from Department", Department.class).list();
        }
    }

    public void updateDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteDepartment(Long id) {
        Transaction transaction = null;
        try (Session session = ConnexionDb.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Department department = session.get(Department.class, id);
            if (department != null) {
                session.delete(department);
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
