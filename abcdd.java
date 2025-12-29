import java.util.ArrayList;
import java.util.Scanner;

public class abcdd{
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<6;i++){
            ar.add(sc.nextLine());
        }
        System.out.println(ar);
        String temp = sc.next();
        ar.set(5, temp);
        sc.close();
        System.out.println(ar);
        ar.remove(4);
        System.out.println(ar);
    }
}