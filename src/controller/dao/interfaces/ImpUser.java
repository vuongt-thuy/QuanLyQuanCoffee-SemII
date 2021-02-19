/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.interfaces;

import controller.ConnectDatabase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.User;

/**
 *
 * @author THUY
 */
public class ImpUser implements IGenerticDAO<User, Integer> {

    private Connection conn;

    public ImpUser() {
        this.conn = ConnectDatabase.getData();
    }

    List<User> list = new ArrayList<>();

    @Override
    public List getList() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call user_select()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setFullname(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setPhone(rs.getString(5));
                u.setLevel_id(rs.getInt(6));
                u.setTimework(rs.getString(7));
                u.setStatus(rs.getBoolean(8));
                u.setCreated_at(rs.getDate(9));

                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(User t) {
        try {
            CallableStatement cs = conn.prepareCall("{call user_add(?,?,?,?,?,?,?,?)}");
            cs.setString(1, t.getUsername());
            cs.setString(2, t.getFullname());
            cs.setString(3, t.getPassword());
            cs.setString(4, t.getPhone());
            cs.setInt(5, t.getLevel_id());
            cs.setString(6, t.getTimework());
            cs.setBoolean(7, true);
            cs.setTimestamp(8, new Timestamp(t.getCreated_at().getTime()));

            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User t) {
        try {
            CallableStatement cs = conn.prepareCall("{call user_update(?,?,?,?,?,?)}");
            cs.setInt(1, t.getId());
            cs.setString(2, t.getUsername());
            cs.setString(3, t.getFullname());
            cs.setString(4, t.getPhone());
            cs.setInt(5, t.getLevel_id());
            cs.setString(6, t.getTimework());

            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User selectByUsername(String username) {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call user_selectByUsername(?)}");
            cs.setString(1, username);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setFullname(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setPhone(rs.getString(5));
                u.setLevel_id(rs.getInt(6));
                u.setTimework(rs.getString(7));
                u.setStatus(rs.getBoolean(8));
                u.setCreated_at(rs.getDate(9));

                return u;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List selectByName(String fullname) {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call user_selectByFullName(?)}");
            cs.setString(1, fullname);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setFullname(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setPhone(rs.getString(5));
                u.setLevel_id(rs.getInt(6));
                u.setTimework(rs.getString(7));
                u.setStatus(rs.getBoolean(8));
                u.setCreated_at(rs.getDate(9));

                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public User selectById(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getListDrinks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getListFoods() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getList(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkCategoryDrink(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkCategoryFood(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDiscount(Integer i, Float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateSalePrice(Integer i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
