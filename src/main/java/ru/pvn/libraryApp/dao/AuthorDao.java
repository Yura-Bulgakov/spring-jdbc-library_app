package ru.pvn.libraryApp.dao;

import ru.pvn.libraryApp.models.Author;

public interface AuthorDao {
    Author getById(long id);

    void create(Author author);
}
