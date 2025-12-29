import java.util.ArrayList;
import java.util.Scanner;

class product{
    String p_name;
    int p_price;
    int p_quantity;

    product(String n,int q, int p){
        this.p_name = n;
        this.p_quantity = q;
        this.p_price = p;
    }
}

class cart {
    public static ArrayList<product> cartItems = new ArrayList<product>();
    static void showItems(){
        for(product p: cartItems){
            System.out.println(p.p_name + " " + p.p_price +" "+ p.p_quantity);
        }
    }
    static void addItems(String n, int q, int p){
        cartItems.add(new product(n, q, p));
    }
    static void removeItems(int p){
        cartItems.remove(p);
        }
    static void purchaseItems(String p){
        for(product oo: cartItems){
            if(0 == oo.p_name.compareToIgnoreCase(p)){
                cartItems.remove(oo);
                System.out.println("Purchase successfull.");
                break;
            }
        }
    }
}


public class cartTask{
    public static void main(String args[]){

        cart.addItems("Sample1", 0, 0);
        cart.addItems("Sample2", 0, 0);
        cart.addItems("Sample3", 0, 0);

        System.out.println("Welcome to cart!\n What would you like to do?");
        String dec = "adf";
        Scanner sc = new Scanner(System.in);
        while(!dec.equals("exit")){
            System.out.println("1. View cart\n2. Add item\n3. Remove items\n4. Purchase items");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    cart.showItems();
                    break;
                case 2:
                    String n = sc.next();
                    int p = sc.nextInt();
                    int q = sc.nextInt();
                    cart.addItems(n,p,q);
                    System.out.println("Item added succesfully!");
                    cart.showItems();
                    break;
                case 3:
                    {p = sc.nextInt();
                    cart.removeItems(p);
                    break;}
                case 4:
                    n = sc.next();
                    cart.purchaseItems(n);    
                    break;
                default:
                    System.out.println("Invalid input!");
                    }
            System.out.println("Do you want to exit?: ");
            dec = sc.next().toLowerCase();
        }
        sc.close();
    }
}
