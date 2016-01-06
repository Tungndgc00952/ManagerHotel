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
public class OrderService {
    public String nameSevice;
    public int idOrder;
    public int quantity;
    public float price;

    public OrderService() {
    }

    public OrderService(String nameSevice, int idOrder, int quantity, float price) {
        this.nameSevice = nameSevice;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.price = price;
    }
    
}
