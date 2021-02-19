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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import model.Order;

/**
 *
 * @author THUY
 */
public class ImpOrder implements IGenerticDAO<Order, Integer> {

    private static Connection conn;
    private List<Order> list = new ArrayList<>();

    public ImpOrder() {
        this.conn = ConnectDatabase.getData();
    }

    @Override
    public List getList() {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call order_selectAll()}");
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt(1));
                o.setTotal_money(rs.getFloat(2));
                o.setCus_pay(rs.getFloat(3));
                o.setCus_receive(rs.getFloat(4));
                o.setCashier(rs.getString(5));
                o.setCreated_at(rs.getTimestamp(6));

                list.add(o);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void add(Order o) {
        try {
            CallableStatement cs = conn.prepareCall("{call order_add(?,?,?,?,?,?)}");
            cs.setInt(1, o.getId());
            cs.setFloat(2, o.getTotal_money());
            cs.setFloat(3, o.getCus_pay());
            cs.setFloat(4, o.getCus_receive());
            cs.setString(5, o.getCashier());

            Date timeNow = new Date();
            cs.setTimestamp(6, new Timestamp(timeNow.getTime()));

            cs.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    @Override
    public Order selectById(Integer id) {
        try {
            CallableStatement cs = conn.prepareCall("{call order_selectById(?)}");
            cs.setInt(1, id);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt(1));
                o.setTotal_money(rs.getFloat(2));
                o.setCus_pay(rs.getFloat(3));
                o.setCus_receive(rs.getFloat(4));
                o.setCashier(rs.getString(5));
                o.setCreated_at(rs.getDate(6));

                return o;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Integer orderID) {
        try {
            CallableStatement cs = conn.prepareCall("{call order_deleteById(?)}");
            cs.setInt(1, orderID);
            cs.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List selectByName(String cashier) {
        list.clear();
        try {
            CallableStatement cs = conn.prepareCall("{call order_selectByCashier(?)}");
            cs.setString(1, cashier);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt(1));
                o.setTotal_money(rs.getFloat(2));
                o.setCus_pay(rs.getFloat(3));
                o.setCus_receive(rs.getFloat(4));
                o.setCashier(rs.getString(5));
                o.setCreated_at(rs.getTimestamp(6));

                list.add(o);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Order t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order selectByUsername(String username) {
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
