package application;

import model.entities.Book;
import model.entities.Client;
import model.entities.Library;
import model.exception.LibraryException;
import model.exception.BookException;
import model.exception.ClientException;

public class Program {
    public static void main(String[] args) {

        Library library = Library.getInstance();
        try {

            Book book1 = new Book(1, "George Orwell", "1984");
            Book book2 = new Book(2, "J.K. Rowling", "Harry Potter e a Pedra Filosofal");
            Book book3 = new Book(3, "J.R.R. Tolkien", "O Senhor dos Anéis");

            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);


            Client client1 = new Client(1, "pedro", "pedro@gmail.com");
            Client client2 = new Client(2, "dudu", "dudu@gmail.com");

            library.addClient(client1);
            library.addClient(client2);


            library.rent(book1, client1);
            System.out.println(client1.getName() + " rented " + book1.getTitle());
            System.out.println();
            System.out.println("books rented by " + client1.getName() + ":");
            client1.showBooks();
            System.out.println();


            library.returnBook(book1, client1);
            System.out.println(client1.getName() + " returned " + book1.getTitle());



        } catch (BookException | ClientException | LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}