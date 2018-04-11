package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class FrontendProgrammer extends Employees {
    public FrontendProgrammer(String name, double salary) {
        this.name = name;
        if (salary < 30000) {
            throw new IllegalArgumentException("Invalid salary " + salary);
        }
        this.salary = salary;
        this.role = "Front End Programmer";
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
