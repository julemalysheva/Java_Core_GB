package ru.geekbrains.hw_seminar3.task1;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeCollectionExample {

    public static void main(String[] args) {

        //создаем объект EmployeeCollection и добавляем в него несколько Employee.
        EmployeeCollection employeeCollection = new EmployeeCollection();

        Employee employee1 = new Freelancer(1010,"Yulya", LocalDate.of(2010, 7, 10), 10.0);
        Employee employee2 = new Worker(1002, "Viki", LocalDate.of(2020, 3, 19), 2000.0);
        Employee employee3 = new Freelancer(909, "Sergey", LocalDate.of(2008, 9, 28), 15.0);
        Employee employee4 = new Worker(1014, "Lena", LocalDate.of(2017, 10, 20), 2500.0);

        employeeCollection.addEmployee(employee1);
        employeeCollection.addEmployee(employee2);
        employeeCollection.addEmployee(employee3);
        employeeCollection.addEmployee(employee3);
        employeeCollection.addEmployee(employee4);

        // Использование в цикле foreach
        for (Employee employee : employeeCollection) {
            System.out.println(employee.getName());
        }

        System.out.println();

        // Использование с помощью итератора
        Iterator<Employee> iterator = employeeCollection.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee.getName());
        }
    }

}
