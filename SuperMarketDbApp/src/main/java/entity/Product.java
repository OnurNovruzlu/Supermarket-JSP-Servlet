package entity;

public class Product {
    private int product_id;
    private String product_name;
    private int product_price;
    private int category_id;
    private Category category;
    
    public Product() {
    }

    public Product(int product_id, String product_name, int product_price, int category_id, Category category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.category_id = category_id;
        this.category = category;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
        @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", product_name=" + product_name + ", product_price=" + product_price + ", category_id=" + category_id + ", category=" + category + '}';
    }
}
