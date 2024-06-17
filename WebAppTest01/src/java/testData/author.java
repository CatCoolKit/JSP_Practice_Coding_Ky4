/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testData;

/**
 *
 * @author manhc
 */
public class author {
    private int id;
    private String name;
    private String tacpham;

    public author() {
    }

    public author(int id, String name, String tacpham) {
        this.id = id;
        this.name = name;
        this.tacpham = tacpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTacpham() {
        return tacpham;
    }

    public void setTacpham(String tacpham) {
        this.tacpham = tacpham;
    }

    @Override
    public String toString() {
        return "userKH{" + "id=" + id + ", name=" + name + ", tacpham=" + tacpham + '}';
    }
    
    
}
