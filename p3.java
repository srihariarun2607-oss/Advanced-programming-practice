import java.util.*;
public class p3 {
    public static void main(String []args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter 3 numbers to compare: ");
        int a=s.nextInt();
        int b=s.nextInt();
        int c=s.nextInt();
        int high;
        if(a>b){
            if(a>c){
                high=a;
            }
            else
            high=c;
        }
        else{
            if(b>c)
            high=b;
            else
            high=c;
        }
        System.out.println("The highest number is: "+high);
    }
}
