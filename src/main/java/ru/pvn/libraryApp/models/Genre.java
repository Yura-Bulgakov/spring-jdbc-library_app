package ru.pvn.libraryApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Genre {

    private long id;

    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
