package org.example.ProductСatalog;

import java.util.List;

public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public void addProduct(Product product) {
        repository.addProduct(product);
    }

    public void listProducts() {
        List<Product> products = repository.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Каталог пуст.");
        } else {
            System.out.println("Каталог товаров:");
            products.forEach(System.out::println);
        }
    }

    public void findProduct(String name) {
        Product product = repository.findByName(name);
        if (product != null) {
            System.out.println("Найден продукт: " + product);
        } else {
            System.out.println("Продукт не найден");
        }
    }
}
