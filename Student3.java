class Student3 {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Student3 s1 = new Student3();
        Student3 s2 = new Student3();

        s1.name = "Bunny";
        s1.age = 19;

        s2.name = "Hari";
        s2.age = 20;

        s1.display();
        System.out.println();

        s2.display();
    }
}