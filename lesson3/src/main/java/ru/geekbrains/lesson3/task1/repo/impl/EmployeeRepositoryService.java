package ru.geekbrains.lesson3.task1.repo.impl;

import ru.geekbrains.lesson3.task1.repo.Employee;
import ru.geekbrains.lesson3.task1.repo.EmployeeRepository;

import java.util.Collection;

public class EmployeeRepositoryService implements EmployeeRepository {
    @Override
    public int add(Employee item) {
        return 0;
    }

    @Override
    public int update(Employee item) {
        return 0;
    }

    @Override
    public int delete(Integer integer) {
        return 0;
    }

    @Override
    public Employee get(Integer integer) {
        return null;
    }

    @Override
    public Collection<Employee> getAll() {
        return null;
    }
}
