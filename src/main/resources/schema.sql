CREATE TABLE books (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    author VARCHAR(255)
);

CREATE TABLE libraries (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE cities (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255)
);

CREATE TABLE library_books (
    library_id INT,
    book_id INT,
    FOREIGN KEY (library_id) REFERENCES libraries(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

CREATE TABLE city_libraries (
    city_id INT,
    library_id INT,
    FOREIGN KEY (city_id) REFERENCES cities(id),
    FOREIGN KEY (library_id) REFERENCES libraries(id)
);