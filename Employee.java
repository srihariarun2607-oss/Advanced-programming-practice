class Employee {
    protected String name;
    protected String employeeID;
    protected double basicSalary;
    
    public Employee(String name, String employeeID, double basicSalary) {
        this.name = name;
        this.employeeID = employeeID;
        this.basicSalary = basicSalary;
    }
    
    public double calculateSalary() {
        return basicSalary;
    }
    
    public void displaySalary() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: " + calculateSalary());
    }
}

class Professor extends Employee {
    public Professor(String name, String employeeID, double basicSalary) {
        super(name, employeeID, basicSalary);
    }
    
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.20);
    }
}

class LabAssistant extends Employee {
    public LabAssistant(String name, String employeeID, double basicSalary) {
        super(name, employeeID, basicSalary);
    }
    
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.10);
    }
}

class AdministrativeStaff extends Employee {
    public AdministrativeStaff(String name, String employeeID, double basicSalary) {
        super(name, employeeID, basicSalary);
    }
    
    public double calculateSalary() {
        return basicSalary + (basicSalary * 0.05);
    }
}

class EmployeeMain {
    public static void main(String[] args) {
        Professor prof = new Professor("Dr. Smith", "EMP001", 50000);
        prof.displaySalary();
        System.out.println();
        
        LabAssistant lab = new LabAssistant("Alice", "EMP002", 30000);
        lab.displaySalary();
        System.out.println();
        
        AdministrativeStaff admin = new AdministrativeStaff("Bob", "EMP003", 25000);
        admin.displaySalary();
    }
}