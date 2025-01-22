package model.entities;

import model.entities.interfaces.Book;
import org.jetbrains.annotations.NotNull;

public class BookEntity implements Book {
    private final int id;
    private final @NotNull String author;
    private final @NotNull String title;
    private boolean isRented;

    public BookEntity(int id, @NotNull String author, @NotNull String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid book ID");
        }
        this.id = id;
        this.author = author;
        this.title = title;
        this.isRented = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public @NotNull String getAuthor() {
        return author;
    }

    @Override
    public @NotNull String getTitle() {
        return title;
    }

    @Override
    public boolean isRented() {
        return isRented;
    }

    @Override
    public void setRented(boolean rented) {
        this.isRented = rented;
    }
}
