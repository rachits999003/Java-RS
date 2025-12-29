import java.util.ArrayList;
import java.util.Scanner;

public class checkfound{
    public static void main(String[] args) {
        ArrayList<String> ar = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<6;i++){
            ar.add(sc.nextLine());
        }
        System.out.println(ar);
        String temp = sc.next();
        sc.close();
        
        boolean flag = false;

        //using normal method
        for(String u: ar){
            if(u.toLowerCase().equals(temp.toLowerCase())){
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        
        
        //Using compareToIgnoreCase
        for(String u: ar){
            if(0 == u.compareToIgnoreCase(temp)){
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }
}