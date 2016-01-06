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
public class Room {
    public String NoRoom;
    public String kindRoom;
    public float price;
    public float priceCurrent;
    public String R_Status;
    public Boolean Select;

    public Room(String NoRoom, String kindRoom, float price, float priceCurrent, String R_Status, boolean Select) {
        this.NoRoom = NoRoom;
        this.kindRoom = kindRoom;
        this.price = price;
        this.priceCurrent = priceCurrent;
        this.R_Status = R_Status;
        this.Select = Select;
    }
    
    public Room(String NoRoom, String kindRoom, float price, float priceCurrent, String R_Status) {
        this.NoRoom = NoRoom;
        this.kindRoom = kindRoom;
        this.price = price;
        this.priceCurrent = priceCurrent;
        this.R_Status = R_Status;
    }

    public Room() {
    }
    
}
