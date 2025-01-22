package model.entities.interfaces;

import model.entities.BookEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Client {
    int getId();
    @NotNull String getName();
    @NotNull String getEmail();
    void addBook(BookEntity book);
    void removeBook(BookEntity book);
    List<BookEntity> getRentedBooks();

}
