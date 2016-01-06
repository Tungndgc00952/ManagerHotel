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
public class Orders {
    public int id;    
    public String nameClient;
    public String nameAcc;
    public long dateIn;
    public long dateOut;
    public float priceRoom;
    public String noRoom;
//    public String nameService;
    public float priceService;
    public float totalPrice;
    public String check;
    public Orders(){
        
    }

    public Orders(int id, String nameClient, String nameAcc, float priceRoom, String noRoom, float priceService, float totalPrice) {
        this.id = id;
        this.nameClient = nameClient;
        this.nameAcc = nameAcc;
        this.priceRoom = priceRoom;
        this.noRoom = noRoom;
        this.priceService = priceService;
        this.totalPrice = totalPrice;
    }

    public Orders(int id, String nameClient, String nameAcc, long dateIn, long dateOut, float priceRoom, String noRoom, float priceService, float totalPrice, String check) {
        this.id = id;
        this.nameClient = nameClient;
        this.nameAcc = nameAcc;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.priceRoom = priceRoom;
        this.noRoom = noRoom;
        this.priceService = priceService;
        this.totalPrice = totalPrice;
        this.check = check;
    }
    


    public Orders(int id, String nameClient, String nameAcc, long dateOut, float priceRoom, String noRoom, float priceService, float totalPrice) {
        this.id = id;
        this.nameClient = nameClient;
        this.nameAcc = nameAcc;
        this.dateOut = dateOut;
        this.priceRoom = priceRoom;
        this.noRoom = noRoom;
        this.priceService = priceService;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameAcc() {
        return nameAcc;
    }

    public void setNameAcc(String nameAcc) {
        this.nameAcc = nameAcc;
    }

    public long getDateIn() {
        return dateIn;
    }

    public void setDateIn(long dateIn) {
        this.dateIn = dateIn;
    }

    public long getDateOut() {
        return dateOut;
    }

    public void setDateOut(long dateOut) {
        this.dateOut = dateOut;
    }

    public float getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(float priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getNoRoom() {
        return noRoom;
    }

    public void setNoRoom(String noRoom) {
        this.noRoom = noRoom;
    }

    public float getPriceService() {
        return priceService;
    }

    public void setPriceService(float priceService) {
        this.priceService = priceService;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
}
