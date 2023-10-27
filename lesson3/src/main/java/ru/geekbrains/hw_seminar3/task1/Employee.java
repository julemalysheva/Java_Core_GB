package ru.geekbrains.hw_seminar3.task1;

import java.time.LocalDate;

/**
 * Абстрактный класс работника
 */
abstract class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private LocalDate joiningDate;

    public Employee(int id, String name, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    // Сравнение двух сотрудников на основе их идентификатора
    /**
     * @param   anotherEmployee - Сотрудник, подлежащий сравнению.
     * @return Отрицательное целое число, ноль или положительное целое число в качестве этого сотрудника
     *      меньше, равно или больше предоставленного объекта employee.
     */
    @Override
    public int compareTo(Employee anotherEmployee) {
        return this.getId() - anotherEmployee.getId();
    }

    /**
     * Абстрактный метод для расчета среднемесячной заработной платы
     * @return среднемесячную заработную плату
     */
    public abstract double calculateAverageMonthlySalary();
}
