package ru.geekbrains.hw_seminar3.task1;

import java.time.LocalDate;

/**
 * Подкласс работника с фиксированной оплатой.
 */
public class Worker extends Employee {
    private double fixedMonthlyPayment;

    public Worker(int id, String name, LocalDate joiningDate, double fixedMonthlyPayment) {
        super(id, name, joiningDate);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return fixedMonthlyPayment;
    }
}
