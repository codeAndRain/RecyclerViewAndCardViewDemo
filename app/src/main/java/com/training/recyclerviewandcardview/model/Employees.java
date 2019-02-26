package com.training.recyclerviewandcardview.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {

    private int numEmployees;
    private List<Employee> employeeList = new ArrayList<>();

    public Employees(int numEmployees) {
        this.numEmployees = numEmployees;
        createEmployees(numEmployees);
    }

    private void createEmployees(int numEmployees) {
        for (int i = 0; i < numEmployees; i++) {
            employeeList.add(Employee.getRandomEmployee());
        }
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getNumEmployees() {
        return employeeList.size();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void updateEmployee(Employee employee) {
        int position = employeeList.indexOf(employee);
        employeeList.set(position, employee);
    }
}
