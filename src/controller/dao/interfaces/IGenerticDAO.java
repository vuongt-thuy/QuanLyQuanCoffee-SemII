/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao.interfaces;

import java.util.List;

/**
 *
 * @author THUY
 */
public interface IGenerticDAO<T, K> {

    public List getList();

    public List getList(K k);

    public void add(T t);

    public void delete(K k);

    public void update(T t);

    public T selectById(K k);

    public List selectByName(String name);

    public T selectByUsername(String username);

    public List getListDrinks();

    public List getListFoods();

    public boolean checkCategoryDrink(K k);

    public boolean checkCategoryFood(K k);
    
    public void updateDiscount(Integer i, Float f);
    
    public void updateSalePrice(Integer i);

}
