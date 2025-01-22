package model.entities.Library;


public final class Library {
    private static final Library instance = new Library();
    public static Library getInstance() {
        return instance;
    }

    private final Books books = new Books();
    private final Clients clients = new Clients();


    public Books getBooks() {
        return books;
    }

    public Clients getClients() {
        return clients;
    }
}
