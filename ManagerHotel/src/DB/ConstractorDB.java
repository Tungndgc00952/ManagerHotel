/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Empty.Client;
import Empty.OrderService;
import Empty.Orders;
import Empty.Room;
import Empty.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ConstractorDB {

    public Connector connector;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<Staff> listStaff;
    private List<Orders> listOrder;
    private List<Room> listRoom;

    public ConstractorDB() {
        connector = new Connector();
    }
    /*
     Manager Client
     */

    public void inserClient(Client c)throws Exception{
//        String name, int Age, String gender, String Address, String phone, String dateIn, String dateOut, int CMND
        String sql = "INSERT INTO Client VALUES(?,?,?,?,?,?,?,?);";
        try {
            con = connector.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, c.name);
            ps.setInt(2, c.Age);
            ps.setString(3, c.gender);
            ps.setString(4, c.Address);
            ps.setString(5, c.phone);
            ps.setString(6, c.dateIn);
            ps.setString(7, c.dateOut);
            ps.setInt(8, c.CMND);
            ps.executeUpdate();
        } catch (Exception ex) {
            
        } finally {
            connector.close(con);
            connector.close(ps);
        }
    }
    /*
     Manager Room
     */

    public List<Room> getListRoom() throws Exception {
        listRoom = new ArrayList<>();
        String Sql = "Select * from Room ";
        try {
            con = connector.getConnection();
            ps = con.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //public Room(String NoRoom, String kindRoom, float price, float priceCurrent, String R_Status)
                String NoRoom = rs.getString(1);
                String kindRoom = rs.getString(2);
                float price = rs.getFloat(3);
                float priceCurrent = rs.getFloat(4);
                String R_Status = rs.getString(5);
                Room r = new Room(NoRoom, kindRoom, price, priceCurrent, R_Status);
                listRoom.add(r);
            }
        } catch (Exception ex) {
            Logger.getLogger(ConstractorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connector.close(con);
            connector.close(ps);
            connector.close(rs);
        }

        return listRoom;
    }

    public Room PrintRoom(String noRoom) {
        String Sql = "select*from Room where NoRoom =?";
        try {
            con = connector.getConnection();
            ps = con.prepareStatement(Sql);
            ps.setString(1, noRoom);
            rs = ps.executeQuery();
            if (rs.next()) {
                String NoRoom = rs.getString(1);
                String kindRoom = rs.getString(2);
                float price = rs.getFloat(3);
                float priceCurrent = rs.getFloat(4);
                String R_Status = rs.getString(5);
                Room r = new Room(NoRoom, kindRoom, price, priceCurrent, R_Status);
                return r;
            }
        } catch (Exception ex) {
            Logger.getLogger(ConstractorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void UpdateRoom(Room r, int i) throws Exception {
        String Sql = "update Room set ";
        if (i == 5) {
            Sql += "R_status=? where NoRoom=?";
            try {
                con = connector.getConnection();
                ps = con.prepareStatement(Sql);
                ps.setString(1, r.R_Status);
                ps.setString(2, r.NoRoom);
                ps.executeUpdate();
            } finally {
                connector.close(con);
                connector.close(ps);
            }
        } else {
            Sql += "kindRoom=?, price=?, priceCurrent=?, R_status=? where NoRoom=?";

            try {
                con = connector.getConnection();
                ps = con.prepareStatement(Sql);
                ps.setString(1, r.kindRoom);
                ps.setFloat(2, r.price);
                ps.setFloat(3, r.priceCurrent);
                ps.setString(4, r.R_Status);
                ps.setString(5, r.NoRoom);
                ps.executeUpdate();

            } finally {
                connector.close(con);
                connector.close(ps);
            }
        }
    }

    public int Login(String userName, String pass) throws Exception {
        Connector connector = new Connector();
        String Sql = "Select * from Accounts where A_NameUser=? and A_PassWord=?";
        con = connector.getConnection();
        ps = con.prepareStatement(Sql);
        ps.setString(1, userName);
        ps.setString(2, pass);
        rs = ps.executeQuery();
        if (rs.next()) {
            return 1;
        } else {
            return 0;
        }
    }

    // DB Staff 
    public void insertStaff(Staff s) throws Exception {
        connector = new Connector();
        String sql = "INSERT INTO Staff VALUES(?,?,?,?,?,?);";
        //INSERT INTO Staff VALUES('A01','thuy','Femal',01696167935,'thuynx@fpt.edu.vn','Manager');
        try {
            con = connector.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, s.id);
            ps.setString(2, s.name);
            ps.setString(3, s.sex);
            ps.setInt(4, s.phone);
            ps.setString(5, s.email);
            ps.setString(6, s.office);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            connector.close(con);
            connector.close(ps);
        }
    }

    public List<Staff> getStaff(String name) throws Exception {
        listStaff = new ArrayList<>();
        connector = new Connector();
        try {
            con = connector.getConnection();
            String Sql = "select * from Staff ";
            if (name != null && !name.equals("")) {
                Sql += "where userName like '" + name + "'";

            }
            ps = con.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //INSERT INTO Staff VALUES('A01','thuy','Femal',01696167935,'thuynx@fpt.edu.vn','Manager');
                String id = rs.getString(1);
                String names = rs.getString(2);
                String mail = rs.getString(5);
                String sex = rs.getString(3);
                int phone = rs.getInt(4);
                String office = rs.getString(6);
                Staff s = new Staff(id, names, sex, phone, mail, office);
                listStaff.add(s);
            }
        } finally {
            connector.close(con);
            connector.close(ps);
            connector.close(rs);
        }
        return listStaff;
    }

    // DB Orfer
    public List<Orders> getOrder(String str, int i) throws Exception {
        listOrder = new ArrayList<>();
        connector = new Connector();
        try {

            con = connector.getConnection();
            String Sql = "Select * from Orders ";
            if (i == 1 && !str.equals("") && str != null) {
                // lay theo ten phong 
                Sql += "where numberRoom like '" + str + "'";
            } else if (!str.equals("") && str != null) {
                // lay theo ten khach hang
                Sql += "where nameClient like '" + str + "'";
            }
            ps = con.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //String nameClient, String nameAcc, long dateIn, long dateOut, float priceRoom, 
                //String noRoom, String nameService, float priceService, float totalPrice
                String check = rs.getString(10);
                if (check == null) {
                    int id = rs.getInt(1);
                    String nameClient = rs.getString(2);
                    String nameAcc = rs.getString(3);
//                    long dateIn = rs.getLong(4);
//                    long dateOut = rs.getLong(5);
                    String noRoom = rs.getString(6);
                    float priceRoom = rs.getFloat(7);
                    String nameService = rs.getString(7);
                    float priceService = rs.getFloat(8);
                    float totalPrice = rs.getFloat(9);
//                Orders o = new Orders(id, nameClient, nameAcc, dateOut, priceRoom, noRoom, priceService, totalPrice);
                    Orders o = new Orders(id, nameClient, nameAcc, priceRoom, noRoom, priceService, totalPrice);
                    listOrder.add(o);
                } else {
                    break;
                }
            }
        } finally {
            connector.close(con);
            connector.close(ps);
            connector.close(rs);
        }
        return listOrder;
    }
    /*
     DB ORDERSERVICES
     */
    private List<OrderService> listOService;

    public List<OrderService> getOService(int str) throws Exception {
        connector = new Connector();
        listOService = new ArrayList<>();
        try {
            String Sql = "select * from OrderServices ";
            if (str != 0) {
                // load du lieu theo idOrder
                Sql += "where idOrder like " + str + "";
            }
            con = connector.getConnection();
            ps = con.prepareStatement(Sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //String nameSevice, int idOrder, int quantity, float price
                String nameSevice = rs.getString(1);
                int idOrder = rs.getInt(2);
                int quantity = rs.getInt(3);
                float price = rs.getFloat(4);
                OrderService o = new OrderService(nameSevice, idOrder, quantity, price);
                listOService.add(o);
            }
        } finally {
            connector.close(con);
            connector.close(ps);
            connector.close(rs);
        }
        return listOService;
    }
}
