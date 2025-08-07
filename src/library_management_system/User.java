package library_management_system;

import java.util.ArrayList;

abstract class User {
	protected String userId;
	protected String name;
	protected ArrayList<String> issuedBooks;
	
	public User(String userId, String name) {
		this.userId = userId;
		this.name = name;
		this.issuedBooks = new ArrayList<>();
	}


	public abstract void showUserType();


	public abstract int getMaxBooks();

	// Regular methods that all users can use
	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getIssuedBooks() {
		return issuedBooks;
	}

	public void addBook(String bookId) {
		issuedBooks.add(bookId);
	}

	public void removeBook(String bookId) {
		issuedBooks.remove(bookId);
	}

	public boolean canIssueMore() {
		return issuedBooks.size() < getMaxBooks();
	}

	public void displayUser() {
		System.out.println("User ID: " + userId);
		System.out.println("Name: " + name);
		System.out.println("Books Issued: " + issuedBooks.size());
		showUserType(); // This will call the child class method
		System.out.println("------------------------");
	}
}


class Student extends User {
	private String course;


	public Student(String userId, String name, String course) {
		super(userId, name); // Call parent constructor
		this.course = course;
	}


	@Override
	public void showUserType() {
		System.out.println("Type: Student");
		System.out.println("Course: " + course);
		System.out.println("Max Books Allowed: " + getMaxBooks());
	}

	@Override
	public int getMaxBooks() {
		return 3; 
	}

	public String getCourse() {
		return course;
	}
}


class Teacher extends User {
	private String subject;


	public Teacher(String userId, String name, String subject) {
		super(userId, name); 
		this.subject = subject;
	}


	@Override
	public void showUserType() {
		System.out.println("Type: Teacher");
		System.out.println("Subject: " + subject);
		System.out.println("Max Books Allowed: " + getMaxBooks());
	}

	@Override
	public int getMaxBooks() {
		return 5; 
	}

	public String getSubject() {
		return subject;
	}
}