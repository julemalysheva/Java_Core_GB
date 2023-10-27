package ru.geekbrains.hw_seminar3.task1;

import java.time.LocalDate;

/**
 * Подкласс работника с почасовой оплатой
 */
public class Freelancer extends Employee{
    private static final double INDICATOR_DAYS = 20.8;
    private static final int ESTIMATED_HOURS = 8;
    private double hourlyRate;

    public Freelancer(int id, String name, LocalDate joiningDate, double hourlyRate) {
        super(id, name, joiningDate);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public double calculateAverageMonthlySalary() {
        return INDICATOR_DAYS * ESTIMATED_HOURS * hourlyRate;
    }
}
