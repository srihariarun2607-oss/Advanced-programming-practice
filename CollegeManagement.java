class Student {
    String name;
    int rollNumber;

    Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
    }
}

class Course {
    String courseName;
    int courseId;

    Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
    }

    void display() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course ID: " + courseId);
    }
}

public class CollegeManagement {
    public static void main(String[] args) {
        Student s = new Student("Varun", 101);
        Course c = new Course("Computer Science", 501);

        s.display();
        c.display();
    }
}
