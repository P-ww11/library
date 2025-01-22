package model.entities.Library;

import model.entities.BookEntity;
import model.entities.ClientEntity;
import model.exception.BookAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

public final class Books {
    private final List<BookEntity> books = new ArrayList<>();

    public BookEntity create(int id, String author, String title) throws BookAlreadyExistsException {
        if (getBook(id) != null) {
            throw new BookAlreadyExistsException("Book already exists with ID: " + id);
        }
        BookEntity book = new BookEntity(id, author, title);
        else if(book = null){
            throw new BookAlreadyExistsException("book does not exist");
        }
        books.add(book);
        return book;
    }

    public void remove(int id) {
        if(id <= 0){throw new IllegalArgumentException("id invalid");}
        BookEntity book = getBook(id);
        if (book != null) {
            books.remove(book);
        }
    }

    public BookEntity getBook(int id) {
        if(id <= 0){throw new IllegalArgumentException("id invalid");}
        for (BookEntity book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<BookEntity> getAll() {
        return new ArrayList<>(books);
    }

    public void returnBook(BookEntity book, ClientEntity client) throws BookAlreadyExistsException {
        if (book == null && client == null) {
            throw new BookAlreadyExistsException("Book or ClientEntity cannot be null");
        }
        else if(!client.getRentedBooks().contains(book)) {
            throw new BookAlreadyExistsException("This client did not rent this book");
        }
        client.removeBook(book);
        book.setRented(false);
    }




}
