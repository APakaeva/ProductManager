import org.example.zadanie13.ru.netology.product.Product;
import org.example.zadanie13.ru.netology.repository.ProductManager;
import org.example.zadanie13.ru.netology.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    Product item1 = new Product(1, "Сказки", 500);
    Product item2 = new Product(2, "Азбука", 1000);
    Product item3 = new Product(3, "Учебник", 1500);

    @Test // добавить продукты
    public void shouldAddNewProducts() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);

        Product[] expected = {item1, item2, item3};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // найти продукт
    public void shouldSearchProduct() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.searchBy("Азбука");

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Азбука");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // добавить продукты и убрать один
    public void shouldAddNewProductsAndDelete() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.removeProductById(item2.getId());

        Product[] expected = {item1, item3};
        Product[] actual = manager.getSavedProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // найти отсутсвующий продукт
    public void shouldNotSearchProduct() {
        ProductManager manager = new ProductManager(new ProductRepository());
        manager.addNewProducts(item1);
        manager.addNewProducts(item2);
        manager.addNewProducts(item3);
        manager.searchBy("Анекдоты");

        Product[] expected = {null};
        Product[] actual = manager.searchBy("Анекдоты");

        Assertions.assertArrayEquals(expected, actual);
    }
}
