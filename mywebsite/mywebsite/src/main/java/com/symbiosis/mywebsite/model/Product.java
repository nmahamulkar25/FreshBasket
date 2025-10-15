package com.symbiosis.mywebsite.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
    @NotBlank(message = "Product name cannot be blank")
    private String productname;



	@NotNull(message = "Price cannot be null")
    @Min(value = 1, message = "Price must be greater than zero")
    private double price;

    
    private String imageurl;
    private String description;
    private String quantity;
    private String category;


    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
    
    
}

