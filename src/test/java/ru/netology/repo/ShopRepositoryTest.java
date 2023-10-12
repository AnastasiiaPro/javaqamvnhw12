package ru.netology.repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(34, "egs", 100);
    Product product2 = new Product(77, "bread", 50);
    Product product3 = new Product(5, "butter", 150);
    ShopRepository repo = new ShopRepository();
    @BeforeEach
    public void shouldAdd() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void shouldDeleteAllProducts() {

        repo.remove(34);
        repo.remove(77);
        repo.remove(5);


        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteOneProduct() {

        repo.removeById(77);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFoundId() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(727);
        });
    }

    @Test
    public void shouldNotFoundIdWithZero() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);
        });
    }

    @Test
    public void shouldNotFoundIdWithMinus() {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-1);
        });
    }
}

