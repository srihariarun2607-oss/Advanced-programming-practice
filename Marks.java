public class Marks {
    int m1,m2,m3;
    void calculate() {
        int total = m1 + m2 + m3;
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + (total / 3.0));
    }
    public static void main(String[] args) {
        Marks studentMarks = new Marks();
        studentMarks.m1 = 85;
        studentMarks.m2 = 90;
        studentMarks.m3 = 78;
        studentMarks.calculate();
    }

}
