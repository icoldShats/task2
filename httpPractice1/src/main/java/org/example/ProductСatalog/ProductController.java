package org.example.ProductСatalog;

public class ProductController {
    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    public void addProduct(Product product) {
        service.addProduct(product);
    }

    public void showProducts() {
        service.listProducts();
    }

    public void findProduct(String name) {
        service.findProduct(name);
    }
}
