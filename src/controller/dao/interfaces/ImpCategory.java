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
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.Product;

/**
 *
 * @author THUY
 */
public class ImpCategory implements IGenerticDAO<Category, Integer> {

    private Connection conn;

    public ImpCategory() {
        this.conn = ConnectDatabase.getData();
    }

    List<Category> list = new ArrayList<>();

    @Override
    public List getList() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call category_select()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setParent_name(rs.getString(2));
                c.setName(rs.getString(3));

                list.add(c);
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Category t) {
        try {
            CallableStatement cs = conn.prepareCall("{call category_add(?,?)}");
            cs.setString(1, t.getParent_name());
            cs.setString(2, t.getName());
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            CallableStatement cs = conn.prepareCall("{call category_delete(?)}");
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }

    @Override
    public void update(Category t) {
        try {
            CallableStatement cs = conn.prepareCall("{call category_update(?,?,?)}");

            cs.setInt(1, t.getId());
            cs.setString(2, t.getParent_name());
            cs.setString(3, t.getName());

            cs.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
    }


    public List selectByName(String name) {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call category_selectByName(?)}");
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setParent_name(rs.getString(2));
                c.setName(rs.getString(3));

                list.add(c);
            }
        } catch (SQLException ex) {
             ex.printStackTrace();
        }
        return list;
    }
   
    @Override
    public Category selectById(Integer k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category selectByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getListDrinks() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call category_viewListDrinks()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setParent_name(rs.getString(2));
                c.setName(rs.getString(3));

                list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public List getListFoods() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call category_viewListFoods()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setParent_name(rs.getString(2));
                c.setName(rs.getString(3));

                list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
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
