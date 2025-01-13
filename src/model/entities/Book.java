package model.entities;

import model.exception.BookException;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Book {
    private final int id;
    private final @NotNull String author;
    private final @NotNull String title;
    private boolean isRented;


    public Book(int id, @NotNull String author,@NotNull String title) throws BookException{
        if(id <= 0){
            throw new BookException("id invalid");
        }
        this.id = id;
        this.author = author;
        this.title = title;
        isRented = false;
    }

    public int getId() {return id;}

    public @NotNull String getAuthor() {return author;}

    public @NotNull String getTitle() {return title;}

    public boolean isRented() {return isRented;}

    public void setRented(boolean rented) {isRented = rented;}


    @Override
    public String toString() {
        return getAuthor() + "- " + getTitle();
    }
}
