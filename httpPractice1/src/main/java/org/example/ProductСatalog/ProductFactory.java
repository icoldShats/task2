package org.example.ProductСatalog;

public interface ProductFactory {
    Product createProduct(String name, double price);
}
class BookFactory implements ProductFactory {
    public Product createProduct(String name, double price) {
        return new Book(name, price);
    }
}

class ToyFactory implements ProductFactory {
    public Product createProduct(String name, double price) {
        return new Toy(name, price);
    }
}
