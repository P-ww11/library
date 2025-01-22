package model.entities.interfaces;

import org.jetbrains.annotations.NotNull;

public interface Book {

    int getId();
    @NotNull String getAuthor();
    @NotNull String getTitle();
    boolean isRented();
    void setRented(boolean rented);


}
