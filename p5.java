import java.util.*;
public class p5 {
    public static void main(String []args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the number for its multiplication table: ");
        int n=s.nextInt();
        for(int i=1;i<=10;i++){
            int prod=n*i;
            System.out.println(n+" x "+i+" = "+prod);
        }
    }
}
