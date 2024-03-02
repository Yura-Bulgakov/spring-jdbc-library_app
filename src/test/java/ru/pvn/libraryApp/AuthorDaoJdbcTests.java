package ru.pvn.libraryApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.pvn.libraryApp.dao.AuthorDaoJdbc;
import ru.pvn.libraryApp.models.Author;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тест методов AuthorDaoJdbc")
@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTests {

    @Autowired
    private AuthorDaoJdbc jdbc;

    @DisplayName("получает книгу по id")
    @Test
    void shouldGetAuthorFromDBById() {
        Author author = jdbc.getById(1);
        assertThat(author).hasFieldOrPropertyWithValue("name", "Михаил");
    }

//    @DisplayName("возвращает новую созданную книгу")
//    @Test
//    void shouldReturnNewAuthor () {
//        Author author = new Author("Дмитрий", "Привалов");
//        jdbc.create(author);
//        Author authorFromDB = jdbc.getByFio("Привалов Д С");
//        assertThat(authorFromDB).hasFieldOrPropertyWithValue("fio", "Привалов Д С");
//    }

}
