package manu.apps.ecart.classes;

public class ProductCategory {

    int categoryId, categoryImage;
    String productName;

    public ProductCategory(int categoryId, int categoryImage, String productName) {
        this.categoryId = categoryId;
        this.categoryImage = categoryImage;
        this.productName = productName;
    }

    // Getters

    public int getCategoryId() {
        return categoryId;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public String getProductName() {
        return productName;
    }


    // Setters

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
