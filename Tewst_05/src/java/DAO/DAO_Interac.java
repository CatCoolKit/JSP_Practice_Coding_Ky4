/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Vector;

/**
 *
 * @author manhc
 */
public interface DAO_Interac <T>{
    int insertRec(T obj);
    int updateRec(T obj);
    int deleteRec(T obj);
    T getObjectById(String id);
    Vector<T> getALlSupplier();
}
