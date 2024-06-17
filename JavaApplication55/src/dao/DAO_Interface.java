/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author manhc
 */
public interface DAO_Interface<T> {
    public int inSert(T t);
    public int upDate(T t);
    public int deLete(T t);
    public ArrayList<T> selectAll();
    public T selectById(T t);
    public ArrayList<T> selectByCondition(String condition);
}
