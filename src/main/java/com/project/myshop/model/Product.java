package com.project.myshop.model;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String description;

    @Column(length = 30)
    private String image;

    private Double price;
    private Integer quantity;
    
   
    @ManyToOne
    private Category category;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Product() {
        System.out.println("com.project.myshop.model.Product.<init>()");
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", description=" + description + ", image=" + image + ", price=" + price + ", quantity=" + quantity + ", category=" + category.getCategoryName() + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }
    
    
}
