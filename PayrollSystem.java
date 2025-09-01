package week3.lab;

class Employee {
    private static int empCounter = 1;
    private String empId, empName, department, empType;
    private double baseSalary;

    public Employee(String name, String dept, double salary, String type) {
        this.empId = "E" + String.format("%03d", empCounter++);
        this.empName = name;
        this.department = dept;
        this.baseSalary = salary;
        this.empType = type;
    }

    // Overloaded salary calculation
    public double calculateSalary(double bonus) { return baseSalary + bonus; }
    public double calculateSalary(int hours, double hourlyRate) { return hours * hourlyRate; }
    public double calculateSalary() { return baseSalary; } // for contract

    public void generatePaySlip(double salary) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(empId)
                .append(" | Name: ").append(empName)
                .append(" | Type: ").append(empType)
                .append(" | Salary: ").append(salary);
        System.out.println(sb);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 50000, "FullTime");
        Employee e2 = new Employee("Bob", "Support", 0, "PartTime");
        Employee e3 = new Employee("Charlie", "Contract", 40000, "Contract");

        e1.generatePaySlip(e1.calculateSalary(5000));
        e2.generatePaySlip(e2.calculateSalary(80, 300));
        e3.generatePaySlip(e3.calculateSalary());
    }
}
