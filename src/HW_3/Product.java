package HW_3;

import java.util.Arrays;

public class Product implements Comparable<Product>{
    private String name;
    private double price;
    private int shelfLife;
    private int quantity;


    public Product() { this("", 0, 0, 0); }

    public Product(String name, double price, int shelfLife, int quantity) {
        this.name = name;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
    }

    public Product(Product other) {
        this(other.name, other.price, other.shelfLife, other.quantity);
    }

    @Override
    public String toString(){
        java.lang.String format = String.format("Product(%s: %.2f, %d years, %d)", name, price, shelfLife, quantity);
        return format;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product other)) return false;
        return this.name.equals(other.name) && this.price == other.price && this.shelfLife == other.shelfLife && this.quantity == other.quantity;
    }

    @Override
    public int compareTo(Product other) {
        return Double.compare(this.price, other.price);
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getShelfLife() { return shelfLife; }
    public int getQuantity() { return quantity; }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setShelfLife(int shelfLife) {
        this.shelfLife = shelfLife;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Product[] filterByNameAndShelfLife(Product[] products, String name, int maxShelfLife){
        return Arrays.stream(products)
                .filter(p -> p.getName().equalsIgnoreCase(name) && p.getShelfLife() <= maxShelfLife)
                .toArray(Product[]::new);
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product("Milk", 25.5, 7, 10),
                new Product("Bread", 15.0, 3, 20),
                new Product("Milk", 28.0, 10, 5),
                new Product("Cheese", 80.0, 30, 2)
        };

        Arrays.sort(products);

        for (Product p : products) {
            System.out.println(p);
        }

        Product[] filtered = Product.filterByNameAndShelfLife(products, "Milk", 7);

        System.out.println("Відібрані товари:");
        Arrays.stream(filtered).forEach(System.out::println);

    }
}
