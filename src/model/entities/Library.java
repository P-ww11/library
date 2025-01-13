package model.entities;

import model.exception.LibraryException;

import java.util.ArrayList;
import java.util.List;

public final class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private static final Library instance = new Library();

    public static Library getInstance() {
        return instance;
    }


    public boolean addBook(Book book) {
     if(getBook(book) != null){
         return false;
     }
     books.add(book);
     return true;
    }
    public boolean addClient(Client client){
        if(getClient(client) != null){
            return false;
        }
        clients.add(client);
        return true;
    }

    public boolean removeClient(Client client){
        if(getClient(client) == null){
            return false;
        }
        clients.remove(client);
        return true;
    }

    public Book getBook(Book book){
        for(Book b : books){
            if(b.getId() == book.getId()){
                return b;
            }
        }
        return null;
    }

    public Client getClient(Client client){
        for(Client c : clients){
            if(c.getName().equals(client.getName()) && c.getId() == client.getId()){
                return c;
            }
        }
        return null;
    }


    public void rent(Book book, Client client) throws LibraryException{
        if(book.isRented()){
            throw new LibraryException("book has already been rented");
        }
        if(getBook(book) == null){
            throw new LibraryException("book does not exist");
        }
        if(getClient(client) == null){
            throw new LibraryException("client does not exist");
        }

        client.addBook(book);
        book.setRented(true);
    }


    public void returnBook(Book book, Client client) throws LibraryException{
        if(getBook(book) == null){
            throw new LibraryException("book already exists");
        }
        if(getClient(client) == null){
            throw new LibraryException("client does not exist");
        }

        client.removeBook(book);
        book.setRented(false);
    }






}
