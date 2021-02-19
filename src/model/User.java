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
public class User {
    private int id;
    private String username;    
    private String fullname;
    private String password;
    private String phone;
    private int level_id;
    private String timework; 
    private boolean status;
    private Date created_at;

    public User() {
    }

    public User(int id, String username, String fullname, String password, String phone, int level_id, String timework, boolean status, Date created_at) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.phone = phone;
        this.level_id = level_id;
        this.timework = timework;
        this.status = status;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getTimework() {
        return timework;
    }

    public void setTimework(String timework) {
        this.timework = timework;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", fullname=" + fullname + ", password=" + password + ", phone=" + phone + ", level_id=" + level_id + ", timework=" + timework + ", status=" + status + ", created_at=" + created_at + '}';
    }
    

    
}
