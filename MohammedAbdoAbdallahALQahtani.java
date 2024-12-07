package main.mohammed.abdo.abdallah.al.qahtani;

import java.util.ArrayList;
import java.util.Scanner;

public class MohammedAbdoAbdallahALQahtani {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> library = new ArrayList<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an operation:");
            System.out.println("1 - Add a Book");
            System.out.println("2 - Search for a Book ");
            System.out.println("3 - Display All Books");
            System.out.println("4- Delete a Book");
            System.out.println("5- View all books for author");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // لتفادي مشاكل الإدخال
            try {
                switch (choice) {

                    case 1://أدخال معلومات الكتاب
                        System.out.println("Enter details for the new book:");
                        System.out.print("Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Language: ");
                        String language = scanner.nextLine();
                        System.out.print("Publishor: ");
                        String publishor = scanner.nextLine();
                        System.out.print("Type: ");
                        String type = scanner.nextLine();
                        System.out.print("Year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine(); // لتفادي مشاكل الإدخال
                        System.out.print("ISBN: ");
                        int ISBN = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Number of page: ");
                        int Numberofpage = scanner.nextInt();
                        scanner.nextLine();
                        //هنا يتم ادخال المعلومات الي الكائن واضافة الي المصفوفة
                        library.add(new Book(title, author, language, publishor, type, year, ISBN, Numberofpage));
                        break;
                    case 2:
                        //  البحث عن كتاب حسب العنوان واللغة والمؤالف
                        System.out.print("Enter the title of the book you want to search for: ");
                        String searchtitle = scanner.nextLine();
                        System.out.print("Enter the language of the book you want to search for: ");
                        String searchLanguage = scanner.nextLine();
                        System.out.print("Enter the Author of the book you want to search for : ");
                        String searchAuthor = scanner.nextLine();
                        for (Book book : library) {
                            if (book.getTitle().equalsIgnoreCase(searchtitle)
                                    && book.getLanguage().equalsIgnoreCase(searchLanguage)
                                    && book.getAuthor().equalsIgnoreCase(searchAuthor)) {
                                book.bookInfoPrint();
                                break;
                            }
                        }
                        System.out.println("not found this Book");

                        break;
                    case 3:
                        // عرض جميع الكتب
                        for (Book book : library) {
                            book.bookInfoPrint();
                        }
                        break;
                    case 4:
                        // البحث عن كتاب و حذفه
                        System.out.print("Enter the title of the book you want to search for: ");
                        String searchandDelete = scanner.nextLine();
                        for (Book book : library) {
                            if (book.getTitle().equalsIgnoreCase(searchandDelete)) {
                                library.remove(book);
                                break;
                            }
                        }

                        break;
                    case 5:
                        //عرض الكتب الخاصه بمولف
                        System.out.print("Enter the Author of the book you want to show all Book : ");
                        String searchauthor = scanner.nextLine();
                        for (Book book : library) {
                            if (book.getAuthor().equalsIgnoreCase(searchauthor)) {
                                book.bookInfoPrint();
                            }
                        }
                        break;
                    case 0:

                        // الخروج من البرنامج
                        System.out.println("Exiting program.");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");

                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
