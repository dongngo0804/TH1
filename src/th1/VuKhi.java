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
public class VuKhi implements Cloneable,Serializable{
    
    String ID;
    int level;
    float ATK;
    float ATKup;
    float ATKspeedup;
   
    
    VuKhi(){
        ID = "";
        level = 0;
        ATK = 0;
        ATKup = 0;
        ATKspeedup = 0;
        
    }
    // Getter and Setter method Scanner in;
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getATK() {
        return ATK;
    }

    public void setATK(float ATK) {
        this.ATK = ATK;
    }

    public float getATKup() {
        return ATKup;
    }

    public void setATKup(float ATKup) {
        this.ATKup = ATKup;
    }

    public float getATKspeedup() {
        return ATKspeedup;
    }

    public void setATKspeedup(float ATKspeedup) {
        this.ATKspeedup = ATKspeedup;
    }
    
    // Input output methods
    void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.print("Nhap ID vu khi: ");
        setID(in.nextLine());
        
        System.out.print("Nhap level cua vu khi: ");
        setLevel(in.nextInt());
        
        System.out.print("Nhap ATK: ");
        setATK(in.nextFloat());
       
        System.out.print("Nhap ATK up (%): ");
        setATKup(in.nextFloat());
        
        System.out.print("Nhap ATK speed up (%): ");
        setATKspeedup(in.nextFloat());
    }
    
    void xuat(){
        System.out.println((char)27+"[34;43mVu khi ID: " + getID());
        System.out.println((char)27+"[34;43mLevel: " + getLevel());
        System.out.println((char)27+"[34;43mATK: " + getATK());
        System.out.println((char)27+"[34;43mATK up: " + getATKup() + "%");
        System.out.println((char)27+"[34;43mATK speed up: " + getATKspeedup()+"%");
    }
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }
    
}
