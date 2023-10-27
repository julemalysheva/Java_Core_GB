package ru.geekbrains.hw_seminar3.task1;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Freelancer(1010,"Yulya", LocalDate.of(2010, 7, 10), 10.0));
        employees.add(new Worker(1002, "Viki", LocalDate.of(2020, 3, 19), 2000.0));
        employees.add(new Freelancer(909, "Sergey", LocalDate.of(2008, 9, 28), 15.0));
        employees.add(new Worker(1014, "Lena", LocalDate.of(2017, 10, 20), 2500.0));

        // Сортировка работников, при этом будет использоваться метод `compareTo()` класса `Employee`
        // для сравнения двух сотрудников и их сортировки.
        Collections.sort(employees);
        System.out.println("Автоматическая сортировка по ID: ");
        for (Employee employee: employees) {
            System.out.println("Имя: " + employee.getName() + " " +
                    "ID : " + employee.getId() + " " +
                    "Среднемесячная зарплата: " + employee.calculateAverageMonthlySalary());
        }

        // Сортировка работников по определенным разным компораторам:
        // по возрастанию заработной платы, используя собственный Компоратор SalaryComparator
        Collections.sort(employees, new SalaryComparator());
        System.out.println("\nСортировка по возрастанию заработной платы: ");
        for (Employee employee: employees) {
            System.out.println("Имя: " + employee.getName() + " " +
                    "ID : " + employee.getId() + " " +
                    "Среднемесячная зарплата: " + employee.calculateAverageMonthlySalary());
        }

        //Сортировка сотрудников по имени
        Comparator<Employee> employeeNameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };

        Collections.sort(employees, employeeNameComparator);

        System.out.println("\nСортировка по имени : ");
        for (Employee employee: employees) {
            System.out.println("Имя: " + employee.getName() + " " +
                    "ID : " + employee.getId() + " " +
                    "Среднемесячная зарплата: " + employee.calculateAverageMonthlySalary());
        }

        // Сортировка сотрудников по дате приема
        Collections.sort(employees, Comparator.comparing(Employee::getJoiningDate));

        System.out.println("\nСортировка по дате приема : ");
        for (Employee employee: employees) {
            System.out.println("Имя: " + employee.getName() + " " +
                    "ID : " + employee.getId() + " " +
                    "Среднемесячная зарплата: " + employee.calculateAverageMonthlySalary() + " " +
                    "Дата приема: " + employee.getJoiningDate());
        }
    }
}
