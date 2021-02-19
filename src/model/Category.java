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
public class Category {
    private int id;
    private String parent_name;
    private String name;

    public Category() {
    }

    public Category(int id, String parent_id, String name) {
        this.id = id;
        this.parent_name = parent_name;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", parent_name=" + parent_name + ", name=" + name + '}';
    }
    
    
}
