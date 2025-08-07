package library_management_system;

public class Book {
    // Private fields (Encapsulation)
    private String bookId;
    private String title;
    private String author;
    private boolean isIssued;
    private String issuedTo;
    
    // Constructor
    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
        this.issuedTo = "";
    }
    
    // Getter methods (Encapsulation - controlled access)
    public String getBookId() {
        return bookId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public boolean isIssued() {
        return isIssued;
    }
    
    public String getIssuedTo() {
        return issuedTo;
    }
    
    // Method to issue book to a user
    public void issueBook(String userId) {
        this.isIssued = true;
        this.issuedTo = userId;
    }
    
    // Method to return book
    public void returnBook() {
        this.isIssued = false;
        this.issuedTo = "";
    }
    
    // Method to display book information
    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + (isIssued ? "Issued to " + issuedTo : "Available"));
        System.out.println("------------------------");
    }
}