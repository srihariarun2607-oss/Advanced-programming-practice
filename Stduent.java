import java.util.*;
public class Stduent{
    String name;
    int rollno;
    String dept;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stduent st = new Stduent();
        System.out.println("Enter name: ");
        st.name = s.nextLine();
        System.out.println("Enter roll number: ");
        st.rollno = s.nextInt();
        System.out.println("Enter department: ");
        st.dept = s.next();
        System.out.println("\nName: " + st.name);
        System.out.println("Roll Number: " + st.rollno);
        System.out.println("Department: " + st.dept);
    }
}
