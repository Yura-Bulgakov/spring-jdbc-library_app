package ru.pvn.libraryApp.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.pvn.libraryApp.models.Author;
import ru.pvn.libraryApp.models.Book;
import ru.pvn.libraryApp.models.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    private final String selectBooks = "SELECT bks.id book_id,\n" +
            "                       bks.name book_name, \n" +
            "                       gnrs.id genre_id, \n" +
            "                       gnrs.name genre_name,\n" +
            "                       aut.id author_id,\n" +
            "                       aut.name author_name,\n" +
            "                       aut.surname author_surname,\n" +
            "        FROM BOOKS bks\n" +
            "        JOIN authors aut ON aut.id = bks.author\n" +
            "        JOIN genres gnrs ON gnrs.id = bks.genre\n";

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc, GenreDaoJdbc genreJdbc, AuthorDaoJdbc authorJdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Book getById(long id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("id", id);
        return jdbc.query(selectBooks +
                        "WHERE bks.id = :id",
                Map.of("id", id),
                new BookExtractor());
    }

    @Override
    public void create(Book book) {
        jdbc.update("insert into books (" +
                        " name,\n" +
                        " author,\n" +
                        " genre\n" +
                        ")" +
                        "   values ( " +
                        " :name,\n" +
                        " :author,\n" +
                        " :genre\n" +
                        ")",
                Map.of("name", book.getName(),
                        "author", book.getAuthor().getId(),
                        "genre", book.getGenre().getId()));
    }

    @Override
    public void update(Book book) {
        jdbc.update("update books  SET" +
                        " name = :name,\n" +
                        " author = :author,\n" +
                        " genre = :genre \n" +

                        "WHERE id = :id",
                Map.of("name", book.getName(),
                        "author", book.getAuthor().getId(),
                        "genre", book.getGenre().getId(),
                        "id", book.getId()));
    }


    @Override
    public void deleteById(long id) {
        jdbc.update("DELETE FROM books WHERE id = :id", Map.of("id", id));
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query(selectBooks +
                " ORDER BY book_id", new BooksExtractor());
    }


    private class BookExtractor implements ResultSetExtractor<Book> {
        @Override
        public Book extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<Book> books = new BooksExtractor().extractData(resultSet);
            if (books.isEmpty()) return null;
            else return books.iterator().next();
        }
    }

    private class BooksExtractor implements ResultSetExtractor<List<Book>> {
        @Override
        public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            Map<Long, Book> books = new HashMap<>();
            while (resultSet.next()) {
                Book book = books.get(resultSet.getLong("book_id"));
                if (book == null) {
                    book = new Book(
                            resultSet.getLong("book_id"),
                            resultSet.getString("book_name"),
                            new Author(resultSet.getLong("author_id"), resultSet.getString("author_name"), resultSet.getString("author_surname")),
                            new Genre(resultSet.getLong("genre_id"), resultSet.getString("genre_name")));
                    books.put(resultSet.getLong("book_id"), book);
                }
            }
            return new ArrayList<>(books.values());
        }
    }
}

