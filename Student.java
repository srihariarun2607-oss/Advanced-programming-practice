import java.util.Scanner;
public class Student {
    String name;
    int rollno;

    void display(){
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollno);
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Student st = new Student();
        System.out.println("Enter name: ");
        st.name = s.nextLine();
        System.out.println("Enter roll number: ");
        st.rollno = s.nextInt();
        st.display();
    }
}
