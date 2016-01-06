/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Contractors;

import DB.ConstractorDB;
import Empty.Orders;
import Empty.Staff;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Constractor {
    private ConstractorDB condb;
    private List<Staff> listStaff;
    public Constractor(){
        condb=new ConstractorDB();
    }
    public int Login(String userName,String pass) throws Exception{
        condb=new ConstractorDB();
        return condb.Login(userName, pass);
    }
    // Manager Staff 
    public List<Staff> getStaff( String name) throws Exception{
        listStaff=condb.getStaff(name);
        return listStaff;
    }
    public void insertStaff(Staff s) throws Exception{
        condb.insertStaff(s);
    }
    private List<Orders> listOrder;
    public List<Orders> getOrder() throws Exception{
        listOrder=condb.getOrder(null, 1);
        return listOrder;
    }
}
