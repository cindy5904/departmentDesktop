package org.example.controller;

import org.example.dao.EmployeDao;
import org.example.model.Employe;

import java.util.List;

public class EmployeController {
    private EmployeDao employeDao = new EmployeDao();

    public void addEmployee(Employe employe) {
        employeDao.addEmployee(employe);
    }

    public List<Employe> getAllEmployes() {
        return employeDao.getAllEmployes();
    }

    public void updateEmploye(Employe employe) {
        employeDao.updateEmploye(employe);
    }

    public void deleteEmploye(Long id) {
        employeDao.deleteEmploye(id);
    }
}
