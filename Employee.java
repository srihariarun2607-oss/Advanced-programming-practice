class Employee {
    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary+" /-");
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.name = "Ravi";
        e1.id = 1001;
        e1.salary = 40000;

        e2.name = "Anjali";
        e2.id = 1002;
        e2.salary = 45000;

        e1.display();
        System.out.println();

        e2.display();
    }
}