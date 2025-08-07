package library_management_system;

import java.util.Scanner;

public class LibraryManagementSystem {
    private static Library library;
    private static Scanner scanner;
    
    public static void main(String[] args) {
  
        library = new Library("City Central Library");
        scanner = new Scanner(System.in);
        
 
        addSampleData();
        

        System.out.println("Welcome to " + "City Central Library" + "!");
        System.out.println("=".repeat(40));
        
        showMenu();
        
        scanner.close();
    }
    

    private static void addSampleData() {
        System.out.println("Adding sample data...\n");
        
  
        library.addBook(new Book("B001", "Java Programming", "John Smith"));
        library.addBook(new Book("B002", "Python Basics", "Alice Johnson"));
        library.addBook(new Book("B003", "Web Development", "Bob Wilson"));
        

        library.addUser(new Student("S001", "Emma Brown", "Computer Science"));
        library.addUser(new Student("S002", "Mike Davis", "Information Technology"));
        library.addUser(new Teacher("T001", "Dr. Sarah Lee", "Programming"));
        
        System.out.println();
    }
    

    private static void showMenu() {
        while (true) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=".repeat(40));
            System.out.println("1. Show All Books");
            System.out.println("2. Show Available Books");
            System.out.println("3. Show All Users");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Add New Book");
            System.out.println("7. Add New User");
            System.out.println("8. Search Book by Title");
            System.out.println("0. Exit");
            System.out.println("-".repeat(40));
            System.out.print("Enter your choice (0-9): ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        library.displayAllBooks();
                        break;
                    case 2:
                        library.displayAvailableBooks();
                        break;
                    case 3:
                        library.displayAllUsers();
                        break;
                    case 4:
                        issueBookMenu();
                        break;
                    case 5:
                        returnBookMenu();
                        break;
                    case 6:
                        addBookMenu();
                        break;
                    case 7:
                        addUserMenu();
                        break;
                    case 8:
                        searchBookMenu();
                        break;
                    case 0:
                        System.out.println("\nThank you for using Library Management System!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 0-9.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
            
 
            System.out.print("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
    

    private static void issueBookMenu() {
        System.out.println("\n=== ISSUE BOOK ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        library.issueBook(bookId, userId);
    }
    

    private static void returnBookMenu() {
        System.out.println("\n=== RETURN BOOK ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        library.returnBook(bookId, userId);
    }
    

    private static void addBookMenu() {
        System.out.println("\n=== ADD NEW BOOK ===");
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();
        
        Book book = new Book(bookId, title, author);
        library.addBook(book);
    }
    

    private static void addUserMenu() {
        System.out.println("\n=== ADD NEW USER ===");
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.print("Choose user type (1 or 2): ");
        
        try {
            int userType = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            if (userType == 1) {
                System.out.print("Enter Course: ");
                String course = scanner.nextLine();
                Student student = new Student(userId, name, course);
                library.addUser(student);
            } else if (userType == 2) {
                System.out.print("Enter Subject: ");
                String subject = scanner.nextLine();
                Teacher teacher = new Teacher(userId, name, subject);
                library.addUser(teacher);
            } else {
                System.out.println("Invalid choice! Please select 1 or 2.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter 1 or 2.");
        }
    }
    
 
    private static void searchBookMenu() {
        System.out.println("\n=== SEARCH BOOK ===");
        System.out.print("Enter book title (or part of title): ");
        String title = scanner.nextLine();
        
        library.searchBookByTitle(title);
    }
    
}
