/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DB.Confix;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ASUS
 */
public class TestObjectFile {
    public void writerFile(Confix con){
        try {   // dat try cacth de tranh ngoai le khi tao va ghi File
            FileOutputStream f = new FileOutputStream("test.dat");   // tao file f tro den student.dat
            ObjectOutputStream oStream = new ObjectOutputStream(f); // dung de ghi theo Object vao file f
            oStream.writeObject(con);   // ghi student theo kieu Object vao file
            oStream.close();
        } catch (IOException e) {
            System.out.println("Error Write file");
        }
    }
    public Confix readFile(){
        Confix con = null;
        try {   // dat try cacth de tranh ngoai le khi tao va doc File
            FileInputStream f = new FileInputStream("test.dat"); // tao file f tro den student.dat
            ObjectInputStream inStream = new ObjectInputStream(f);  // dung de doc theo Object vao file f
            // dung inStream doc theo Object, ep kieu tra ve la Student
            con = (Confix) inStream.readObject();
            
            inStream.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        } catch (IOException e) {
            System.out.println("Error Read file");
        }
        return con;
    }
    // gi mot doi tuong ra file
    public static void main(String[] args) {
        Confix con=new Confix("abc", "def", "g", "l0", "n");
        TestObjectFile test=new TestObjectFile();
        test.writerFile(con);
        Confix cons=test.readFile();
        System.out.println(" adress : "+cons.Address);
    }
}
