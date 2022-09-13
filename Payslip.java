import java.util.*;
import java.time.*;

public class Payslip {
    public static boolean calculated = false;
    public static Employee employee = new Employee();
    
    public Payslip() {
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Payslip solution!");
        System.out.println();

        Scanner console = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String stringInput = console.nextLine();
        employee.setFName(stringInput);

        System.out.println("Please enter your last name: ");
        stringInput = console.nextLine();
        employee.setLName(stringInput);

        System.out.println("Please enter your annual salary: ");
        boolean flag = true;
        while (flag) {
            try {
                double doubleInput = Double.parseDouble(console.nextLine());
                employee.setSalary(doubleInput);
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Please enter a whole number!");
            }
        }

        System.out.println("Please enter your super rate (in %): ");
        flag = true;
        while (flag) {
            try {
                double doubleInput = Double.parseDouble(console.nextLine());
                employee.setSuper(doubleInput);
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Please enter a number!");
            }
        }

        System.out.println("Please enter your payment start date (format in year/month/day): ");
        flag = true;
        while (flag) {
            try {
                String stringInput1 = console.nextLine();
                List<String> startDateList = Arrays.asList(stringInput1.split("/"));
                int intInput1 = Integer.parseInt(startDateList.get(0));
                int intInput2 = Integer.parseInt(startDateList.get(1));
                int intInput3 = Integer.parseInt(startDateList.get(2));
                employee.setStartDate(intInput1, intInput2, intInput3);
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Please enter it in the following format: year/month/day");
            }
        }

        System.out.println("Please enter your payment end date (format in year/month/day): ");
        flag = true;
        while (flag) {
            try {
                String stringInput1 = console.nextLine();
                List<String> endDateList = Arrays.asList(stringInput1.split("/"));
                int intInput1 = Integer.parseInt(endDateList.get(0));
                int intInput2 = Integer.parseInt(endDateList.get(1));
                int intInput3 = Integer.parseInt(endDateList.get(2));
                employee.setEndDate(intInput1, intInput2, intInput3);
                flag = false;
            }
            catch (Exception e) {
                System.out.println("Please enter it in the following format: year/month/day ");
            }
        }

        System.out.println();
        System.out.println("Your payslip has been generated: ");
        System.out.println("Name: " + employee.getFName() + " " + employee.getLName());
        System.out.println("Pay Period: " + employee.getStartDate() + " to " + employee.getEndDate());
        Period diff = Period.between(employee.getStartDate(), employee.getEndDate());
        System.out.println("Period duration: " + diff.getYears() + " year(s), " + diff.getMonths() + " month(s), " + diff.getDays() + "day(s)");
        double monthlySalary = Math.round(employee.getSalary()/12);
        System.out.println("Gross income: " + monthlySalary);
        double incomeTax = 0;

        if (employee.getSalary() < 18201) {
            incomeTax = 0;
        }
        else if (employee.getSalary() < 37001) {
            incomeTax = 0.19 * (employee.getSalary() - 18200);
        }
        else if (employee.getSalary() < 87001) {
            incomeTax = 3572 + 0.325 * (employee.getSalary() - 37000);
        }
        else if (employee.getSalary() < 180001) {
            incomeTax = 19822 + 0.37 * (employee.getSalary() - 87000);
        }
        else {
            incomeTax = 54232 + 0.45 * (employee.getSalary() - 180000);
        }

        incomeTax = Math.round(incomeTax/12);
        System.out.println("Income tax: " + incomeTax);

        double netIncome = monthlySalary - incomeTax;
        System.out.println("Net income: " + netIncome);

        double superIncome = Math.round( (employee.getSuperRate()/100) * monthlySalary);
        System.out.println("Super: " + superIncome);
    }
}
