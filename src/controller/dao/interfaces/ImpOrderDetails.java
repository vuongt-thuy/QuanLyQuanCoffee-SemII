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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Order;
import model.OrderDetails;

/**
 *
 * @author THUY
 */
public class ImpOrderDetails implements IGenerticDAO<OrderDetails, Integer> {

    private static Connection conn;

    public ImpOrderDetails() {
        this.conn = ConnectDatabase.getData();
    }

    List<OrderDetails> list = new ArrayList<>();

    @Override
    public List getList() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call orderDetails_selectAll()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                OrderDetails od = new OrderDetails();
                od.setOrder_id(rs.getInt(1));
                od.setPro_id(rs.getString(2));
                od.setPro_name(rs.getString(3));
                od.setQuantity(rs.getInt(4));
                od.setPrice(rs.getFloat(5));

                list.add(od);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List getList(Integer orderID) {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call orderDetails_selectByID(?)}");
            cs.setInt(1, orderID);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                OrderDetails od = new OrderDetails();
                od.setOrder_id(rs.getInt(1));
                od.setPro_id(rs.getString(2));
                od.setPro_name(rs.getString(3));
                od.setQuantity(rs.getInt(4));
                od.setPrice(rs.getFloat(5));

                list.add(od);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(OrderDetails o) {
        try {
            CallableStatement cs = conn.prepareCall("{call orderDetails_add(?,?,?,?,?)}");
            cs.setInt(1, o.getOrder_id());
            cs.setString(2, o.getPro_id());
            cs.setString(3, o.getPro_name());
            cs.setInt(4, o.getQuantity());
            cs.setFloat(5, o.getPrice());

            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer orderID) {
        try {
            CallableStatement cs = conn.prepareCall("{call orderDetails_delete(?)}");
            cs.setInt(1, orderID);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public OrderDetails selectById(Integer orderID) {
        return null;
    }

    @Override
    public void update(OrderDetails t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List selectByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetails selectByUsername(String username) {
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
