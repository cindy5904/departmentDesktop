package org.example.controller;

import org.example.dao.DepartmentDao;
import org.example.model.Department;

import java.util.List;

public class DepartmentController {
    private DepartmentDao departmentDao = new DepartmentDao();

    public void addDepartment(Department department) {
        departmentDao.addDepartment(department);
    }

    public List<Department> getAllDepartments() {
        return departmentDao.getAllDepartments();
    }

    public void updateDepartment(Department department) {
        departmentDao.updateDepartment(department);
    }

    public void deleteDepartment(Long id) {
        departmentDao.deleteDepartment(id);
    }
}
