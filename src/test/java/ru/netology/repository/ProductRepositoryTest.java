package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Product first = new Book(1, "Book1", 300, "Author1");
    Product second = new Book(2, "Book2", 200, "Author2");
    Product third = new Smartphone(3, "Smartphone1", 55000, "Producer");
    Product fourth = new Smartphone(4, "Smartphone2", 33000, "Producer");

    @BeforeEach
    public void SetUp() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
    }

    @Test
    public void shouldAddAndFindAll() {

        Product[] expected = {first, second, third, fourth};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDelete() {

        repo.removeById(second.getId());

        Product[] expected = {first, third, fourth};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

}
