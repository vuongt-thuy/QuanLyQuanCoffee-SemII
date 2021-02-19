/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author THUY
 */
public class Product {
    private String id;
    private String name;
    private int cat_id;
    private String image;
    private float price;
    private float discount;
    private float sale_price;

    public Product() {
    }

    public Product(String id, String name, int cat_id, String image, float price, float discount, float sale_price) {
        this.id = id;
        this.name = name;
        this.cat_id = cat_id;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.sale_price = sale_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getSale_price() {
        return sale_price;
    }

    public void setSale_price(float sale_price) {
        this.sale_price = sale_price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", cat_id=" + cat_id + ", image=" + image + ", price=" + price + ", discount=" + discount + ", sale_price=" + sale_price + '}';
    }
    
    

    
    
    
}
