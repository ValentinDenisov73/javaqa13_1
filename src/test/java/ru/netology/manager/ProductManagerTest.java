package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product first = new Book(1, "Book1", 300, "Author1");
    Product second = new Book(2, "Book2", 200, "Author2");
    Product third = new Smartphone(3, "Smartphone1", 55000, "Producer");
    Product fourth = new Smartphone(4, "Smartphone2", 33000, "Producer");

    @BeforeEach
    public void SetUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void shouldSearchByBookName() {

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.searchBy("Book");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchBySmartPhoneName() {

        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Smartphone2");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void shouldNotSearch() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Book3");
        Assertions.assertArrayEquals(expected, actual);

    }

}
