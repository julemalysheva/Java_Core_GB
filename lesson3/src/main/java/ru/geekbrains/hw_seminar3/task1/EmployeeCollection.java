package ru.geekbrains.hw_seminar3.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmployeeCollection implements Iterable<Employee>, Iterator<Employee> {
    public List<Employee> employees;
    int index;

    public EmployeeCollection() {
        this.employees = new ArrayList<>();
        this.index = 0;
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee))
            employees.add(employee);
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < employees.size();
            }

            @Override
            public Employee next() {
                return employees.get(index++);
            }
        };
    }

    @Override
    public boolean hasNext() {
        return index < employees.size();
    }

    @Override
    public Employee next() {
        return employees.get(index++);
    }
}
