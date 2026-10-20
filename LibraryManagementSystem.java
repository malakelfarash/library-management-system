import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of books you have: ");
        int maxBooks = input.nextInt();

        String[] bookTitles = new String[maxBooks];
        String[] bookDescriptions = new String[maxBooks];
        boolean[] bookStatuses = new boolean[maxBooks];
        int bookCount = 0;

        boolean running = true;

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a Book");
            System.out.println("2. Search for a Book (by Title or ID)");
            System.out.println("3. Issue a Book (by ID)");
            System.out.println("4. Return a Book (by ID)");
            System.out.println("5. Delete a Book (by ID)");
            System.out.println("6. Edit Book Details (Title/Description by ID)");
            System.out.println("7. View All Books");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            
            switch (choice) {
                case 1:
                    if (bookCount >= maxBooks) {
                        System.out.println("Library is full. Cannot add more books.");
                    } else {
                        System.out.print("Enter book title: ");
                        String title = input.next();
                        if (title == null || title.trim().isEmpty()) {
                            System.out.println("Error: Book title cannot be empty.");
                        } else {
                            System.out.print("Enter book description: ");
                            input.nextLine();
                            String description = input.nextLine();
                            bookTitles[bookCount] = title;
                            bookDescriptions[bookCount] = description;
                            bookStatuses[bookCount] = false;
                            bookCount++;
                            System.out.println("Book added successfully.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter book title or ID: ");
                    String search = input.next();
                    boolean found = false;
                    for (int i = 0; i < bookCount; i++) {
                        if (bookTitles[i].equalsIgnoreCase(search) || String.valueOf(i + 1).equals(search)) {
                            System.out.println("Book ID: " + (i + 1));
                            System.out.println("Title: " + bookTitles[i]);
                            System.out.println("Description: " + bookDescriptions[i]);
                            if (bookStatuses[i]) {
                                System.out.println("Availability: Issued");
                            } else {
                                System.out.println("Availability: Available");
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book ID to issue: ");
                    int issueId = input.nextInt();
                    if (issueId > 0 && issueId <= bookCount) {
                        if (!bookStatuses[issueId - 1]) {
                            bookStatuses[issueId - 1] = true;
                            System.out.println("Book issued successfully.");
                        } else {
                            System.out.println("Book is already issued.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter book ID to return: ");
                    int returnId = input.nextInt();
                    if (returnId > 0 && returnId <= bookCount) {
                        if (bookStatuses[returnId - 1]) {
                            bookStatuses[returnId - 1] = false;
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Book was not issued.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter book ID to delete: ");
                    int deleteId = input.nextInt();
                    if (deleteId > 0 && deleteId <= bookCount) {
                        for (int i = deleteId - 1; i < bookCount - 1; i++) {
                            bookTitles[i] = bookTitles[i + 1];
                            bookDescriptions[i] = bookDescriptions[i + 1];
                            bookStatuses[i] = bookStatuses[i + 1];
                        }
                        bookTitles[bookCount - 1] = null;
                        bookDescriptions[bookCount - 1] = null;
                        bookStatuses[bookCount - 1] = false;
                        bookCount--;
                        System.out.println("Book deleted successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 6:
                    System.out.print("Enter book ID to edit: ");
                    int editId = input.nextInt();
                    if (editId > 0 && editId <= bookCount) {
                        System.out.print("Enter new title: ");
                        String newTitle = input.next();
                        if (newTitle == null || newTitle.trim().isEmpty()) {
                            System.out.println("Error: Book title cannot be empty.");
                        } else {
                            System.out.print("Enter new description: ");
                            input.nextLine();
                            String newDescription = input.nextLine();
                            bookTitles[editId - 1] = newTitle;
                            bookDescriptions[editId - 1] = newDescription;
                            System.out.println("Book details updated successfully.");
                        }
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    if (bookCount == 0) {
                        System.out.println("No books available.");
                    } else {
                        for (int i = 0; i < bookCount; i++) {
                            System.out.println("Book ID: " + (i + 1));
                            System.out.println("Title: " + bookTitles[i]);
                            System.out.println("Description: " + bookDescriptions[i]);
                            if (bookStatuses[i]) {
                                System.out.println("Availability: Issued");
                            } else {
                                System.out.println("Availability: Available");
                            }
                        }
                    }
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
