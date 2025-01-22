package model.entities.Library;

import model.entities.BookEntity;
import model.entities.ClientEntity;
import model.exception.BookAlreadyExistsException;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class Clients {
    private final List<ClientEntity> clients = new ArrayList<>();

    public ClientEntity create(int id, @NotNull String name,@NotNull String email) {
        if(id <= 0){throw new IllegalArgumentException("id invalid");}
        ClientEntity client = new ClientEntity(id, name, email);
        clients.add(client);
        return client;
    }

    public void remove(int id) {
        if(id <= 0){throw new IllegalArgumentException("id invalid");}
        ClientEntity client = getClient(id);
        if (client != null) {
            clients.remove(client);
        }
    }

    public ClientEntity getClient(int id) {
        if(id <= 0){throw new IllegalArgumentException("id invalid");}
        for (ClientEntity client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    public List<ClientEntity> getAll() {
        return new ArrayList<>(clients);
    }

    public void rent(BookEntity book, ClientEntity client) throws BookAlreadyExistsException {
        if (book == null){
            throw new BookAlreadyExistsException("Book cannot be null");
        }
        else if(client == null) {
            throw new BookAlreadyExistsException("ClientEntity cannot be null");
        }
        else if (book.isRented()) {
            throw new BookAlreadyExistsException("Book has already been rented");
        }
        client.addBook(book);
        book.setRented(true);
    }
}



