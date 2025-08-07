package library_management_system;

import java.util.ArrayList;

public class Library {
	private String libraryName;
	private ArrayList<Book> books;
	private ArrayList<User> users;

	// Constructor
	public Library(String libraryName) {
		this.libraryName = libraryName;
		this.books = new ArrayList<>();
		this.users = new ArrayList<>();
	}

	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book '" + book.getTitle() + "' added successfully!");
	}

	public void addUser(User user) {
		users.add(user);
		System.out.println("User '" + user.getName() + "' added successfully!");
	}

	public Book findBook(String bookId) {
		for (Book book : books) {
			if (book.getBookId().equals(bookId)) {
				return book;
			}
		}
		return null;
	}

	public User findUser(String userId) {
		for (User user : users) {
			if (user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}

	public void issueBook(String bookId, String userId) {
		Book book = findBook(bookId);
		User user = findUser(userId);

		if (book == null) {
			System.out.println("Book not found!");
			return;
		}

		if (user == null) {
			System.out.println("User not found!");
			return;
		}

		if (book.isIssued()) {
			System.out.println("Book is already issued to someone else!");
			return;
		}

		if (!user.canIssueMore()) {
			System.out.println("User has reached maximum book limit!");
			return;
		}

		book.issueBook(userId);
		user.addBook(bookId);
		System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
	}

	public void returnBook(String bookId, String userId) {
		Book book = findBook(bookId);
		User user = findUser(userId);

		if (book == null) {
			System.out.println("Book not found!");
			return;
		}

		if (user == null) {
			System.out.println("User not found!");
			return;
		}

		if (!book.isIssued() || !book.getIssuedTo().equals(userId)) {
			System.out.println("This book is not issued to this user!");
			return;
		}

		book.returnBook();
		user.removeBook(bookId);
		System.out.println("Book '" + book.getTitle() + "' returned by " + user.getName());
	}

	public void displayAllBooks() {
		System.out.println("\n=== ALL BOOKS IN " + libraryName + " ===");
		if (books.isEmpty()) {
			System.out.println("No books in library!");
			return;
		}

		for (Book book : books) {
			book.displayBook();
		}
	}

	public void displayAvailableBooks() {
		System.out.println("\n=== AVAILABLE BOOKS ===");
		boolean found = false;

		for (Book book : books) {
			if (!book.isIssued()) {
				book.displayBook();
				found = true;
			}
		}

		if (!found) {
			System.out.println("No books available!");
		}
	}

	public void displayAllUsers() {
		System.out.println("\n=== ALL USERS ===");
		if (users.isEmpty()) {
			System.out.println("No users registered!");
			return;
		}

		for (User user : users) {
			user.displayUser();
		}
	}

	public void searchBookByTitle(String title) {
		System.out.println("\n=== SEARCH RESULTS ===");
		boolean found = false;

		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				book.displayBook();
				found = true;
			}
		}

		if (!found) {
			System.out.println("No book found with title containing: " + title);
		}
	}
}