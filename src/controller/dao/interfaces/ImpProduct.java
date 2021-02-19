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
public class ImpProduct implements IGenerticDAO<Product, String> {

    private Connection conn;

    public ImpProduct() {
        this.conn = ConnectDatabase.getData();
    }

    List<Product> list = new ArrayList<>();

    @Override
    public List getList() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call product_select()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setCat_id(rs.getInt(3));
                p.setImage(rs.getString(4));
                p.setPrice(rs.getFloat(5));
                p.setDiscount(rs.getFloat(6));
                p.setSale_price(rs.getFloat(7));

                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Product t) {
        try {
            CallableStatement cs = conn.prepareCall("{call product_add(?,?,?,?,?,?)}");
            cs.setString(1, t.getId());
            cs.setString(2, t.getName());
            cs.setInt(3, t.getCat_id());
            cs.setString(4, t.getImage());
            cs.setFloat(5, t.getPrice());
            cs.setFloat(6, t.getSale_price());

            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            CallableStatement cs = conn.prepareCall("{call product_delete(?)}");
            cs.setString(1, id);

            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Product t) {
        try {
            CallableStatement cs = conn.prepareCall("{call product_update(?,?,?,?,?,?)}");
            cs.setString(1, t.getId());
            cs.setString(2, t.getName());
            cs.setInt(3, t.getCat_id());
            cs.setString(4, t.getImage());
            cs.setFloat(5, t.getPrice());
            cs.setFloat(6, t.getSale_price());

            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List getListDrinks() {
//        list.clear();
        List<Product> listDrinks = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{call selectListDrinks()}");

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setCat_id(rs.getInt(3));
                p.setImage(rs.getString(4));
                p.setPrice(rs.getFloat(5));
                p.setDiscount(rs.getFloat(6));
                p.setSale_price(rs.getFloat(7));

                listDrinks.add(p);
            }
            return listDrinks;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listDrinks;
    }

    @Override
    public List getListFoods() {
//        list.clear();
        List<Product> listFoods = new ArrayList<>();
        try {
            CallableStatement cs = conn.prepareCall("{call selectListFoods()}");

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setCat_id(rs.getInt(3));
                p.setImage(rs.getString(4));
                p.setPrice(rs.getFloat(5));
                p.setDiscount(rs.getFloat(6));
                p.setSale_price(rs.getFloat(7));

                listFoods.add(p);
            }
            return listFoods;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listFoods;
    }

    @Override
    public Product selectById(String id) {
        try {
            CallableStatement cs = conn.prepareCall("{call product_selectById(?)}");
            cs.setString(1, id);

            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setCat_id(rs.getInt(3));
                p.setImage(rs.getString(4));
                p.setPrice(rs.getFloat(5));
                p.setSale_price(rs.getFloat(6));

                return p;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List selectByName(String name) {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call product_selectByName(?)}");
            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getString(1));
                p.setName(rs.getString(2));
                p.setCat_id(rs.getInt(3));
                p.setImage(rs.getString(4));
                p.setPrice(rs.getFloat(5));
                p.setSale_price(rs.getFloat(6));

                list.add(p);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean checkCategoryFood(String proId) {
        List<Product> listPro = getList();
        List<Category> listCat = new ImpCategory().getList();

        for (Product p : listPro) {
            if (p.getId().equals(proId)) {
                for (Category c : listCat) {
                    if (p.getCat_id() == c.getId() && c.getParent_name().equals("Foods")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkCategoryDrink(String proId) {
        List<Product> listPro = getList();
        List<Category> listCat = new ImpCategory().getList();

        for (Product p : listPro) {
            if (p.getId().equals(proId)) {
                for (Category c : listCat) {
                    if (p.getCat_id() == c.getId() && c.getParent_name().equals("Drinks")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void updateDiscount(Integer cat_id, Float discount) {
        try {
            CallableStatement cs = conn.prepareCall("{call product_updateDiscount(?,?)}");
            cs.setInt(1, cat_id);
            cs.setFloat(2, discount);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateSalePrice(Integer cat_id) {
        try {
            CallableStatement cs = conn.prepareCall("{call product_updateSalePrice(?)}");
            cs.setInt(1, cat_id);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Product selectByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getList(String k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
