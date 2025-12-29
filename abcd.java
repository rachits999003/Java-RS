import java.util.ArrayList;
import java.util.Scanner;

public class abcd{
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<5;i++){
            ar.add(sc.nextLine());
        }
        System.out.println(ar);
        String temp = sc.next();
        ar.add(temp);
        ar.set(0, temp);
        System.out.println(ar);
        sc.close();
    }
}