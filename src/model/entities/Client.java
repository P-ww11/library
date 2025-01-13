package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.exception.ClientException;
import org.jetbrains.annotations.NotNull;

public final class Client {
    private final int id;
    private final @NotNull String name;
    private final @NotNull String email;
    private final @NotNull List<Book> rentedBooks = new ArrayList<>();



    public Client(int id, @NotNull String name,@NotNull String email) throws ClientException{
      if(id <= 0){
          throw new ClientException("id invalid");
      }
      this.id = id;
      this.name = name;
      this.email = email;
    }


    public int getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public void addBook(Book book){
       rentedBooks.add(book);
    }

    public void removeBook(Book book){
        rentedBooks.remove(book);
    }


    public void showBooks(){
        for(Book b : rentedBooks){
            if(b != null) {
                System.out.println(b.toString());
            }
        }
    }


    @Override
    public String toString() {
        return getName() + "- " + getEmail();
    }
}
