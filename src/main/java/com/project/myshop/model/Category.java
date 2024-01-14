package com.project.myshop.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;
@Entity
@Table(name="Category")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    
    @Column(length = 30)
    private String description;
    
    @Column(length = 20,unique = true)
    private String categoryName;

    public Integer getCategoryId() {
        return categoryId;
    }
    
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Product> product;
    
    public Category() {
        System.out.println("com.project.myshop.model.Category.<init>()");
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }   

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryId=" + categoryId + ", description=" + description + ", categoryName=" + categoryName + ", product=" + product + '}';
    }
    
    
}
