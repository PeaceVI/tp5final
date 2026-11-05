package library.app;

import library.model.Book;
import library.model.DigitalBook;
import library.service.Library;
import library.util.NumberClassifier;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        library.addItem(new Book("The Catcher in the Rye", "J.D. Salinger"));
        library.addItem(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addItem(new DigitalBook("Digital Fortress", "Dan Brown", 5));

        System.out.println("List of Books in the Library:");
        for (String description : library.listAllItems()) {
            System.out.println(description);
        }

        NumberClassifier.printSequence(10);
    }
}
