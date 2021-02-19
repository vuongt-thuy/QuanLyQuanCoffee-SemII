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
public class OrderDetails {
    private int order_id;
    private String pro_id;
    private String pro_name;
    private int quantity;
    private float price;

    public OrderDetails() {
    }

    public OrderDetails(int order_id, String pro_id, String pro_name, int quantity, float price) {
        this.order_id = order_id;
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }
    
    

    @Override
    public String toString() {
        return "OrderDetails{" + "order_id=" + order_id + ", pro_id=" + pro_id + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
}
