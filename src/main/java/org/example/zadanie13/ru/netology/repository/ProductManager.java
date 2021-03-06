package org.example.zadanie13.ru.netology.repository;

import org.example.zadanie13.ru.netology.product.Product;

public class ProductManager {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void addNewProducts(Product productForAdd) {
        repository.addNewProducts(productForAdd);
    }

    public void removeProductById(int id) {
        repository.removeProductById(id);
    }

    public Product[] getSavedProducts() {
        return
                repository.getSavedProducts();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[1];
        for (Product product : repository.getSavedProducts()) {
            if (matches(product, text)) {
                result[0] = product;
                return result;
            } else {
                result[0] = null;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}