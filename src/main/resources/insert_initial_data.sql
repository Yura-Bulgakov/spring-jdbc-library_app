INSERT INTO genres(name) VALUES ('Роман');
INSERT INTO genres(name) VALUES ('Повесть');
INSERT INTO genres(name) VALUES ('Поэма');
INSERT INTO genres(name) VALUES ('Рассказ');
INSERT INTO genres(name) VALUES ('Сборник стихов');
INSERT INTO genres(name) VALUES ('Пьеса');

INSERT INTO authors(name, surname) VALUES ('Михаил', 'Булгаков');
INSERT INTO authors(name, surname) VALUES ('Александр', 'Пушкин');
INSERT INTO authors(name, surname) VALUES ('Лев', 'Толстой');
INSERT INTO authors(name, surname) VALUES ('Сергей', 'Есенин');
INSERT INTO authors(name, surname) VALUES ('Владимир', 'Маяковский');

INSERT INTO books(name, genre, author) VALUES ('Мастер и Маргарита', 1, 1);
INSERT INTO books(name, genre, author) VALUES ('Собачье сердце', 2, 1);
INSERT INTO books(name, genre, author) VALUES ('Евгений Онегин', 1, 2);
INSERT INTO books(name, genre, author) VALUES ('Руслан и Людмила', 3, 2);
INSERT INTO books(name, genre, author) VALUES ('Война и мир', 1, 3);
INSERT INTO books(name, genre, author) VALUES ('Метель', 4, 3);
INSERT INTO books(name, genre, author) VALUES ('Радуница', 5, 4);
INSERT INTO books(name, genre, author) VALUES ('Стихи скандалиста', 5, 4);
INSERT INTO books(name, genre, author) VALUES ('Клоп', 6, 5);
INSERT INTO books(name, genre, author) VALUES ('Облако в штанах', 3, 5);

