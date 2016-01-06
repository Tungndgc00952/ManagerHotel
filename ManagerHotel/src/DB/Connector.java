/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.awt.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Connector {
//

    private String url = "jdbc:sqlserver://0.0.0.0:1433;databaseName=ManagerHotel";
    private String user = "sa";
    private String pass = "thuy";

    public Connection getConnection() throws Exception {
        try {
            Confix con;
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("confix.dat"))) {
                con = (Confix) in.readObject();
            }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://" + con.getAddress() + ":" + con.getPort() + ";databaseName=" + con.getNameData(), con.getUserName(), con.getPass());
        } catch (FileNotFoundException ex) {
            Component Main = null;
            JOptionPane.showMessageDialog(Main, "No config connection file please click File->Config connection", "Error File config.dat not found !", 2);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    public Connection getConnection() throws SQLException {
//        try {
//            Confix con;
//            FileInputStream f=new FileInputStream("confix.dat");
//            try {
//                ObjectInputStream in =new ObjectInputStream(f);
//                con=(Confix)in.readObject();
//                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//                return DriverManager.getConnection("jdbc:sqlserver://" + con.getAddress() + ":" + con.getPort() + ";databaseName=" + con.getNameData(), con.getUserName(), con.getPass());
//            }            
//            catch (IOException ex) {
//                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Connector.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    public Connection getConnection() throws Exception {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection("jdbc:sqlserver://" + "0.0.0.0" + ":" + "1433" + ";databaseName=" + "ManagerHotel", user, pass);
//    }

    public void close(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
