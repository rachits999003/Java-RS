import java.util.ArrayList;
import java.util.Scanner;

class User{
    float balance = 0;
    String username;
    private String password;

    static String BankName = "SBI";
    static ArrayList<User> users = new ArrayList<>();

    User(String user, String pass){
        this.username = user;
        this.password = pass;
        this.balance = 0;
    }

    static boolean createUser(String user, String pass){
        if(user == null || pass == null || user.isEmpty() || pass.isEmpty()){
            System.err.println("Username and password cannot be empty.");
            return false;
        }
        for(User u : users){
            if(u.username.equals(user)){
                System.err.println("User already exists.");
                return false;
            }
        }
        users.add(new User(user, pass));
        System.out.println("User created: " + user);
        return true;
    }

    static User login(String user, String pass){
        for(User u : users){
            if(u.username.equals(user)){
                if(u.checkPassword(pass)){
                    System.out.println("Login successful, welcome " + user);
                    return u;
                } else {
                    System.err.println("Invalid credentials.");
                    return null;
                }
            }
        }
        System.err.println("User not found.");
        return null;
    }

    void loginUser(String user, String pass){
        if(user.equals(username) && pass.equals(password)){
            System.out.println("Login successfully, welcome "+ username);
        }
        else{
            System.err.println("Invalid credentials.");
        }
    }

    boolean checkPassword(String pass){
        return pass != null && pass.equals(password);
    }

    float fetchBalance(){
        return balance;
    }
    
    void withdrawMoney(float amount){
        if (amount > balance ){
            System.out.println("Insufficient fund!");
        }
        else {
            balance -= amount;
            System.out.printf("Successfully withdrawn %.2f rupees.%n", amount);
        }
    }
    void depositMoney(float amount){
        if (amount > 0 ){
            balance += amount;
            System.out.printf("Successfully deposited %.2f rupees.%n", amount);
        }
        else {
            System.out.println("Ye kya amount hai be!?");
        }
    }


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("\n--- Bank System ("+BankName+") ---");
            System.out.println("1. Create User");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");
            String choice = sc.nextLine().trim();
            if(choice.equals("1")){
                System.out.print("Enter username: ");
                String u = sc.nextLine().trim();
                System.out.print("Enter password: ");
                String p = sc.nextLine().trim();
                createUser(u, p);
            } else if(choice.equals("2")){
                System.out.print("Username: ");
                String u = sc.nextLine().trim();
                System.out.print("Password: ");
                String p = sc.nextLine().trim();
                User logged = login(u, p);
                if(logged != null){
                    while(true){
                        System.out.println("\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Logout");
                        System.out.print("Choose: ");
                        String c2 = sc.nextLine().trim();
                        if(c2.equals("1")){
                            System.out.printf("Balance: %.2f%n", logged.fetchBalance());
                        } else if(c2.equals("2")){
                            System.out.print("Amount to deposit: ");
                            try{
                                float amt = Float.parseFloat(sc.nextLine().trim());
                                logged.depositMoney(amt);
                            } catch(NumberFormatException e){
                                System.err.println("Invalid amount.");
                            }
                        } else if(c2.equals("3")){
                            System.out.print("Amount to withdraw: ");
                            try{
                                float amt = Float.parseFloat(sc.nextLine().trim());
                                logged.withdrawMoney(amt);
                            } catch(NumberFormatException e){
                                System.err.println("Invalid amount.");
                            }
                        } else if(c2.equals("4")){
                            System.out.println("Logged out.");
                            break;
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                }
            } else if(choice.equals("3")){
                System.out.println("Goodbye.");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}