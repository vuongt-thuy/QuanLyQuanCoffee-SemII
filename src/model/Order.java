/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author THUY
 */
public class Order {
    private int id;
    private float total_money;
    private float cus_pay;
    private float cus_receive;
    private String cashier;
    private Date created_at;

    public Order() {
    }

    public Order(int id, float total_money, float cus_pay, float cus_receive, String cashier, Date created_at) {
        this.id = id;
        this.total_money = total_money;
        this.cus_pay = cus_pay;
        this.cus_receive = cus_receive;
        this.cashier = cashier;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public float getCus_pay() {
        return cus_pay;
    }

    public void setCus_pay(float cus_pay) {
        this.cus_pay = cus_pay;
    }

    public float getCus_receive() {
        return cus_receive;
    }

    public void setCus_receive(float cus_receive) {
        this.cus_receive = cus_receive;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", total_money=" + total_money + ", cus_pay=" + cus_pay + ", cus_receive=" + cus_receive + ", cashier=" + cashier + ", created_at=" + created_at + '}';
    }
            
    
}
