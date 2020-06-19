package manu.apps.ecart.classes;

public class Product {

    int productId;
    String productName;
    String productQty;
    String productPrice;
    int productImage;

    public Product(int productId, String productName, String productQty, String productPrice, int productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    // Getters

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductQty() {
        return productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getProductImage() {
        return productImage;
    }

    // Setters

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }


}
