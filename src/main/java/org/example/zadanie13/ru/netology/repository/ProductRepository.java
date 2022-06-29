package org.example.zadanie13.ru.netology.repository;

import org.example.zadanie13.ru.netology.product.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void addNewProducts(Product productForAdd) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = productForAdd;
        items = tmp;
    }

    public void removeProductById(int id) {
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] getSavedProducts() {
        return items;
    }

}