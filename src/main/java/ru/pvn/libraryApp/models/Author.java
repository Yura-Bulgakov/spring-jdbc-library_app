package ru.pvn.libraryApp.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Author {

    private long id;

    private String name;

    private String surname;


    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
