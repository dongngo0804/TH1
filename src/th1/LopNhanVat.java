/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author ngohu
 */
public class LopNhanVat implements Cloneable, Serializable{
    private String ID;
    private String ten;
    
    
    public LopNhanVat(){
        ID = "";
        ten = "";

    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    
    public void nhap(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Nhap ID lop nhan vat: ");
        setID(in.nextLine());
        
        
        System.out.println("Nhap ten lop nhan vat: ");
        setTen(in.nextLine());
    }
    
    public void xuat(){
        System.out.println((char)27+"[34;43mID lop nhan vat: " + getID());
        System.out.println((char)27+"[34;43mTen lop nhan vat: " + getTen());
    }
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }
    
    
}
