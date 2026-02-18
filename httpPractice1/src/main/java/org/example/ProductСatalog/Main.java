package org.example.ProductСatalog;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        ProductService service = new ProductService(repository);
        ProductController controller = new ProductController(service);

        ProductFactory bookFactory = new BookFactory();
        ProductFactory toyFactory = new ToyFactory();

        controller.addProduct(bookFactory.createProduct("Java Programming", 40.0));
        controller.addProduct(bookFactory.createProduct("Python Cookbook", 35.0));
        controller.addProduct(toyFactory.createProduct("Lego Set", 50.0));
        controller.addProduct(toyFactory.createProduct("Rubik's Cube", 15.0));

        controller.showProducts();

        controller.findProduct("Lego Set");
        controller.findProduct("iPhone");
    }
}
