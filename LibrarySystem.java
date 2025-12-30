import java.util.ArrayList;
import java.util.Scanner;

class Book {
    public String b_name;
    public String b_author;    
    public int b_quantity;    
    public String b_genre;
}

class LibraryUser {
    public String u_name;
    public String u_pass;
    public ArrayList<String> borrowed_books;

    LibraryUser(String un, String pw) {
        u_name = un;
        u_pass = pw;
        borrowed_books = new ArrayList<>();
    }
}

public class LibrarySystem {
    static ArrayList<LibraryUser> users = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static LibraryUser currentUser;

    static void signUp(String un, String pw) {
        users.add(new LibraryUser(un, pw));
        System.out.println("User created successfully!");
    }

    static void login(String un, String pw, Scanner sc) {
        for (LibraryUser u : users) {
            if (un.equals(u.u_name) && pw.equals(u.u_pass)) {
                System.out.println("Login successfull. Welcome " + u.u_name + "!");
                currentUser = u;
                showMenu(sc);
                return;
            }
        }
        System.out.println("Invalid username or password.");
    }

    static void showMenu(Scanner sc) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Borrow book");
            System.out.println("2. Return book");
            System.out.println("3. Renew book");
            System.out.println("4. View books");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter book name: ");
                    String bn = sc.nextLine();
                    borrowBook(bn);
                    break;
                case 2:
                    System.out.print("Enter book name: ");
                    bn = sc.nextLine();
                    returnBook(bn);
                    break;
                case 3:
                    System.out.print("Enter book name: ");
                    bn = sc.nextLine();
                    renewBook(bn);
                    break;
                case 4:
                    viewBooks();
                    break;
                case 5:
                    System.out.println("Logged out successfully!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    static void borrowBook(String bn) {
        for (Book b : books) {
            if (b.b_name.equalsIgnoreCase(bn)) {
                if (b.b_quantity > 0) {
                    b.b_quantity--;
                    currentUser.borrowed_books.add(bn);
                    System.out.println("Book \"" + bn + "\" borrowed successfully!");
                } else {
                    System.out.println("Book not available.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    static void returnBook(String bn) {
        if (currentUser.borrowed_books.contains(bn)) {
            currentUser.borrowed_books.remove(bn);
            for (Book b : books) {
                if (b.b_name.equalsIgnoreCase(bn)) {
                    b.b_quantity++;
                    System.out.println("Book \"" + bn + "\" returned successfully!");
                    return;
                }
            }
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    static void renewBook(String bn) {
        if (currentUser.borrowed_books.contains(bn)) {
            System.out.println("Book \"" + bn + "\" renewed successfully for 14 more days!");
        } else {
            System.out.println("You did not borrow this book.");
        }
    }

    static void viewBooks() {
        System.out.println("\n=== Available Books ===");
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println("• " + b.b_name + " by " + b.b_author + 
                    " (" + b.b_genre + ") - Available: " + b.b_quantity);
            }
        }
        System.out.println("\n=== Your Borrowed Books ===");
        if (currentUser.borrowed_books.isEmpty()) {
            System.out.println("You have not borrowed any books.");
        } else {
            for (String book : currentUser.borrowed_books) {
                System.out.println("• " + book);
            }
        }
    }

    public static void main(String[] args) {
        // Initialize demo users
        users.add(new LibraryUser("Demouser1", "pass"));
        users.add(new LibraryUser("Demouser2", "pass"));
        users.add(new LibraryUser("Demouser3", "pass"));

        // Initialize library with sample books
        Book b1 = new Book();
        b1.b_name = "The Great Gatsby";
        b1.b_author = "F. Scott Fitzgerald";
        b1.b_genre = "Fiction";
        b1.b_quantity = 5;
        books.add(b1);

        Book b2 = new Book();
        b2.b_name = "1984";
        b2.b_author = "George Orwell";
        b2.b_genre = "Dystopian";
        b2.b_quantity = 3;
        books.add(b2);

        Book b3 = new Book();
        b3.b_name = "To Kill a Mockingbird";
        b3.b_author = "Harper Lee";
        b3.b_genre = "Fiction";
        b3.b_quantity = 4;
        books.add(b3);

        Book b4 = new Book();
        b4.b_name = "Pride and Prejudice";
        b4.b_author = "Jane Austen";
        b4.b_genre = "Romance";
        b4.b_quantity = 2;
        books.add(b4);

        Book b5 = new Book();
        b5.b_name = "The Catcher in the Rye";
        b5.b_author = "J.D. Salinger";
        b5.b_genre = "Fiction";
        b5.b_quantity = 3;
        books.add(b5);

        Book b6 = new Book();
        b6.b_name = "Brave New World";
        b6.b_author = "Aldous Huxley";
        b6.b_genre = "Dystopian";
        b6.b_quantity = 2;
        books.add(b6);

        Book b7 = new Book();
        b7.b_name = "The Hobbit";
        b7.b_author = "J.R.R. Tolkien";
        b7.b_genre = "Fantasy";
        b7.b_quantity = 4;
        books.add(b7);

        Book b8 = new Book();
        b8.b_name = "Sherlock Holmes";
        b8.b_author = "Arthur Conan Doyle";
        b8.b_genre = "Mystery";
        b8.b_quantity = 3;
        books.add(b8);

        System.out.println("Welcome to BookBhandar!");

        Scanner sc = new Scanner(System.in);
        boolean appRunning = true;

        while (appRunning) {
            System.out.println("\nWhat would you like to do today?");
            System.out.println("---------------------------------");
            System.out.println("1. Login");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String un = sc.nextLine();
                    System.out.print("Enter password: ");
                    String pw = sc.nextLine();
                    login(un, pw, sc);
                    break;
                case 2:
                    System.out.print("Enter username: ");
                    un = sc.nextLine();
                    System.out.print("Enter password: ");
                    pw = sc.nextLine();
                    signUp(un, pw);
                    break;
                case 3:
                    System.out.println("Thank you for using BookBhandar! Goodbye!");
                    appRunning = false;
                    break;
                default:
                    System.out.println("Invalid input! Please try again.");
                    break;
            }
        }
        sc.close();
    }
}
