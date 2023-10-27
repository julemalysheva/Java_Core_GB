package ru.geekbrains.hw_seminar3.task1;

import java.util.Comparator;

/**
 * Компоратор для сортировки работников по возрастанию заработной платы
 */
public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        double salary1 = o1.calculateAverageMonthlySalary();
        double salary2 = o2.calculateAverageMonthlySalary();
        return Double.compare(salary1, salary2);
    }
}
