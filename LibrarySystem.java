package week3.lab;

class Book {
    private static int bookCounter = 1;
    private static int totalBooks = 0, availableBooks = 0;

    private String bookId, title, author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.bookId = "B" + String.format("%03d", bookCounter++);
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        totalBooks++;
        availableBooks++;
    }

    public void issueBook() {
        if (!isAvailable) throw new IllegalStateException("Book already issued.");
        isAvailable = false;
        availableBooks--;
    }

    public void returnBook() {
        if (isAvailable) throw new IllegalStateException("Book was not issued.");
        isAvailable = true;
        availableBooks++;
    }

    public void displayBookInfo() {
        System.out.println(bookId + " | " + title + " by " + author + " | Available: " + isAvailable);
    }

    public static int getAvailableBooks() { return availableBooks; }
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
}

class Member {
    private String memberId, memberName;
    private String[] booksIssued;
    private int bookCount;

    public Member(String id, String name) {
        this.memberId = id;
        this.memberName = name;
        this.booksIssued = new String[5];
        this.bookCount = 0;
    }

    public void borrowBook(Book book) {
        if (bookCount >= 5) throw new IllegalStateException("Limit reached.");
        book.issueBook();
        booksIssued[bookCount++] = book.getBookId();
        System.out.println(memberName + " borrowed " + book.getTitle());
    }

    public void displayMemberInfo() {
        System.out.println("Member: " + memberId + " | " + memberName + " | Books issued: " + bookCount);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling");
        Book b2 = new Book("Python Basics", "Guido");

        Member m1 = new Member("M001", "Sanyam");

        b1.displayBookInfo();
        m1.borrowBook(b1);
        b1.displayBookInfo();
        m1.displayMemberInfo();

        System.out.println("Available books: " + Book.getAvailableBooks());
    }
}
