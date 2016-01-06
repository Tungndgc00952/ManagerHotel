/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class Confix implements Serializable{
    public String Address;
    public String Port;
    public String nameData;
    public String userName;
    public String pass;
    public Confix(){
        Address="0.0.0.0";
        Port="1433";
        nameData="ManagerHotel";
        userName="sa";
        pass="thuy";
    }

    public Confix(String Address, String Port, String nameData, String userName, String pass) {
        this.Address = Address;
        this.Port = Port;
        this.nameData = nameData;
        this.userName = userName;
        this.pass = pass;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String Port) {
        this.Port = Port;
    }

    public String getNameData() {
        return nameData;
    }

    public void setNameData(String nameData) {
        this.nameData = nameData;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
