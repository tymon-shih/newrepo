import java.util.*;
import java.time.*;

public class Employee {
    private String fName;
    private String lName;
    private double salary;
    private LocalDate startDate;
    private LocalDate endDate;
    private double superRate;

    public Employee() {
        fName = "";
        lName = "";
        salary = 0;
        startDate = LocalDate.of(2022, 01, 01);
        endDate = LocalDate.of(2022, 01, 01);
        superRate = 0;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getSuperRate() {
        return superRate;
    }

    public void setFName(String newFName) {
        fName = newFName;
    }

    public void setLName(String newLName) {
        lName = newLName;
    }

    public void setSalary(double newSalary) {
        salary = newSalary;
    }

    public void setStartDate(int year, int month, int day) {
        startDate = LocalDate.of(year, month, day);
    }

    public void setEndDate(int year, int month, int day) {
        endDate = LocalDate.of(year, month, day);
    }

    public void setSuper(double newSuperRate) {
        superRate = newSuperRate;
    }
}
