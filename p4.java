import java.util.*;
public class p4 {
    public static void main(String []args){
        Scanner d=new Scanner(System.in);
        System.out.println("Enter the number to find factorial: ");
        int n=d.nextInt();
        int fact=1;
        for(int i=1;i<=n;i++)
        fact*=i;
        
        System.out.println("Factorial: "+fact);
    }
}
