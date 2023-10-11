import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    Product product1 = new Product(34, "egs", 100);
    Product product2 = new Product(77, "bread", 50);
    Product product3 = new Product(5, "butter", 150);

    @Test
    public void shouldDeleteAllProductsWithId() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(34);
        repo.removeById(77);
        repo.removeById(5);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldDeleteAllProductsWithOneId() {
        ShopRepository repo = new ShopRepository();

        repo.add(product2);

        repo.removeById(77);

        Product[] actual = repo.findAll();
        Product[] expected = {product2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFoundId() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(727);
        });
    }

    @Test
    public void shouldNotFoundIdWithZero() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);
        });
    }

    @Test
    public void shouldNotFoundIdWithMinus() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-1);
        });
    }
}

