package id.ac.ui.cs.advprog.tutorial3.composite;

import id.ac.ui.cs.advprog.tutorial3.composite.higherups.Ceo;
import id.ac.ui.cs.advprog.tutorial3.composite.higherups.Cto;
import id.ac.ui.cs.advprog.tutorial3.composite.techexpert.BackendProgrammer;
import id.ac.ui.cs.advprog.tutorial3.composite.techexpert.FrontendProgrammer;
import id.ac.ui.cs.advprog.tutorial3.composite.techexpert.NetworkExpert;
import id.ac.ui.cs.advprog.tutorial3.composite.techexpert.SecurityExpert;
import id.ac.ui.cs.advprog.tutorial3.composite.techexpert.UiUxDesigner;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Ceo luffy = new Ceo("Luffy", 500000.00);
        company.addEmployee(luffy);

        Cto zorro = new Cto("Zorro", 320000.00);
        company.addEmployee(zorro);

        BackendProgrammer franky = new BackendProgrammer("Franky", 94000.00);
        company.addEmployee(franky);

        BackendProgrammer usopp = new BackendProgrammer("Usopp", 200000.00);
        company.addEmployee(usopp);

        FrontendProgrammer nami = new FrontendProgrammer("Nami", 66000.00);
        company.addEmployee(nami);

        FrontendProgrammer robin = new FrontendProgrammer("Robin", 130000.00);
        company.addEmployee(robin);

        UiUxDesigner sanji = new UiUxDesigner("sanji", 177000.00);
        company.addEmployee(sanji);

        NetworkExpert brook = new NetworkExpert("Brook", 83000.00);
        company.addEmployee(brook);

        SecurityExpert chopper = new SecurityExpert("Chopper", 80000.00);
        company.addEmployee(chopper);

        List<Employees> allEmployees = company.getAllEmployees();

        //print all employees, display their name and role
        allEmployees.forEach((employees) -> System.out.println(employees.getName() + " - "
            + employees.getRole()));
        System.out.println("Company total net salaries: " + company.getNetSalaries());
    }
}