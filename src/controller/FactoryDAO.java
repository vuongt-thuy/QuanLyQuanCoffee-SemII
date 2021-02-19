/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.dao.interfaces.IGenerticDAO;
import controller.dao.interfaces.ImpCategory;
import controller.dao.interfaces.ImpOrder;
import controller.dao.interfaces.ImpOrderDetails;
import controller.dao.interfaces.ImpProduct;
import controller.dao.interfaces.ImpUser;

/**
 *
 * @author THUY
 */
public class FactoryDAO {
    public static IGenerticDAO getData(String type) {
        if (type == "product") {
            return new ImpProduct();
        }
        
        if (type == "category") {
            return new ImpCategory();
        }
        
        if (type == "user") {
            return new ImpUser();
        }
        
        if (type == "order") {
            return new ImpOrder();
        }
        
        if (type == "orderDetails") {
            return new ImpOrderDetails();
        }
        
        return null;
    }
}
