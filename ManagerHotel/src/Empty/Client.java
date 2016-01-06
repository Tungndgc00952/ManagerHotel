/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Empty;

/**
 *
 * @author ASUS
 */
public class Client {
    public String name;
    public int Age;
    public String gender;
    public String Address;
    public String phone;
    public String dateIn;
    public String dateOut;
    public int CMND;

    public Client() {
    }

    public Client(String name, int Age, String gender, String Address, String phone, String dateIn, String dateOut, int CMND) {
        this.name = name;
        this.Age = Age;
        this.gender = gender;
        this.Address = Address;
        this.phone = phone;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.CMND = CMND;
    }
    
}
