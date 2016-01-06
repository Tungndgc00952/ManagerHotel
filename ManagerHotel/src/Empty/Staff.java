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
public class Staff {

    public String id;
    public String name;
    public String sex;
    public int phone;
    public String email;
    public String office;
    public Staff(){
        
    }
    public Staff(String id, String name, String sex, int phone, String email, String office) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.office = office;
    }

    public Staff(String name, String sex, int phone, String email, String office) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.office = office;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
    
}
