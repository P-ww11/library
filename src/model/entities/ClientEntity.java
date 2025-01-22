package model.entities;


import java.util.ArrayList;
import java.util.List;

import model.entities.interfaces.Client;
import org.jetbrains.annotations.NotNull;

public class ClientEntity implements Client {
    private final int id;
    private final @NotNull String name;
    private final @NotNull String email;
    private final List<BookEntity> rentedBooks = new ArrayList<>();

    public ClientEntity(int id, @NotNull String name, @NotNull String email) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid client ID");
        }
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull String getEmail() {
        return email;
    }

    @Override
    public void addBook(BookEntity book) {
        rentedBooks.add(book);
    }

    @Override
    public void removeBook(BookEntity book) {
        rentedBooks.remove(book);
    }

    @Override
    public List<BookEntity> getRentedBooks() {
        return new ArrayList<>(rentedBooks);
    }

    @Override
    public String toString() {
        return getName() + " - " + getEmail();
    }
}

