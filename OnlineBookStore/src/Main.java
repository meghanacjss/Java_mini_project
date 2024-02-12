import Service.Book;
import Service.Bookstore;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                try {
                    System.out.println("ENTER LOGIN USERNAME");
                    String username = scanner.nextLine();
                    System.out.println("ENTER LOGIN PASSWORD");
                    String password = scanner.nextLine();
                    System.out.print("Enter your credit/debit card number: ");

                    int cardNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (cardNumber > 0) {
                        System.out.println("Transaction completed successfully.");

                        Bookstore bookstore = new Bookstore();
                        bookstore.addBook(new Book("Book1", "Software", 10));
                        bookstore.addBook(new Book("Book2", "History", 5));
                        bookstore.addBook(new Book("Book3", "English", 15));
                        bookstore.addBook(new Book("Book4", "datascience", 35));
                        bookstore.addBook(new Book("Book5", "java", 45));

                        System.out.println("Available Book Categories:");
                        System.out.println("1. Software\n2. History\n3. English\n4. Science\n5. Hardware");
                        System.out.println("Enter the category number to view books: ");
                        int categoryNumber = scanner.nextInt();
                        scanner.nextLine();
                        String selectedCategory = getCategoryByChoice(categoryNumber);
                        List<Book> booksInCategory = getBooksByCategory(bookstore, selectedCategory);
                        System.out.println("Books in " + selectedCategory + " category:");
                        booksInCategory.stream().filter(book -> book.getQuantity() > 0)
                                .forEach(book -> System.out.println(book.getTitle() + " - Quantity: " + book.getQuantity()));
//                for (Book book : booksInCategory) {
//                    System.out.println(book.getTitle() + " - Quantity: " + book.getQuantity());
//                }

                        System.out.print("Enter the title of the book you want to buy: ");
                        String selectedBookTitle = scanner.nextLine();

                        Book selectedBook = bookstore.findBookByTitle(selectedBookTitle);

                        if (selectedBook != null && selectedBook.getQuantity() > 0) {
                            System.out.println("Order placed successfully for " + selectedBook.getTitle());
                        } else {
                            System.out.println("Sorry, the selected book is not available.");
                        }
                    } else {
                        System.out.println("Transaction is unsuccessful");
                    }
                    Bookstore bookstore = new Bookstore();
                    System.out.print("Enter your admin username: ");
                    String username1 = scanner.nextLine();
                    System.out.println("username is correct then go to next step");

                    System.out.print("Enter your admin password: ");
                    String password1 = scanner.nextLine();

                    System.out.println("password is correct");
                    Book newBook = new Book("NewBook", "Science", 15);
                    bookstore.addBook(newBook);
                    System.out.println("New book added successfully");

                    System.out.println("Updated list of books:");
                    Book newBook1 = new Book("NewBook", "social", 25);
                    bookstore.addBook(newBook1);
                    List<Book> updatedBooks = bookstore.getBooks().stream()
                            .peek(book -> System.out.println(
                                    book.getTitle() + " - Category: " + book.getCategory() +
                                            " - Quantity: " + book.getQuantity()))
                            .collect(Collectors.toList());


                    System.out.println("New book updated successfully.");

                    System.out.println("deleted list of books:");
                    List<Book> deletedBooks = bookstore.getBooks().stream()
                            .filter(book -> book.getQuantity() > 15)
                            .peek(book -> System.out.println(
                                    book.getTitle() + " - Category: " + book.getCategory() +
                                            " - Quantity: " + book.getQuantity()))
                            .collect(Collectors.toList());
                    boolean continueProgram = true;

                    do {
                        System.out.print("Do you want to continue (Yes/No): ");
                        String continueChoice = scanner.nextLine();

                        if (continueChoice.equalsIgnoreCase("yes")) {
                            System.out.println("Continuing with the program...\n Available Book Categories:" +
                                    " \n 1. Software\n2. History\n3. English\n4. Science\n5. Hardware");
                        } else if (continueChoice.equalsIgnoreCase("no")) {
                            System.out.println("Exiting from the program");
                            System.exit(0);
                        } else {
                            System.out.println("Invalid choice. Please enter Yes or No.");
                        }

                    } while (continueProgram);

                } catch (InputMismatchException e) {
                    System.out.println("Input mismatch exception. Please enter valid input.");
                }
            }
            private static String getCategoryByChoice(int choice) {
                switch (choice) {
                    case 1:
                        return "Software";
                    case 2:
                        return "History";
                    case 3:
                        return "English";
                    case 4:
                        return "Science";
                    case 5:
                        return "Hardware";
                    default:
                        System.out.println("Invalid category number. Please choose a valid option.");
                        System.exit(0);
                        return "";
                }
            }
            private static List<Book> getBooksByCategory(Bookstore bookstore, String category) {
                List<Book> booksInCategory = new ArrayList<>();
                for (Book book : bookstore.getBooks()) {
                    if (book.getCategory().equalsIgnoreCase(category)) {
                        booksInCategory.add(book);
                    }
                }
                return booksInCategory;
            }
        }












































































































































































































































































































//                //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
//        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");
//
//        for (int i = 1; i <= 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + i);
//            }
    