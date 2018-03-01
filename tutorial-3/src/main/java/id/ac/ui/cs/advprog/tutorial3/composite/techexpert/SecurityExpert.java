package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class SecurityExpert extends Employees {
    public SecurityExpert(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String getRole() {
        return super.getRole();
    }
}