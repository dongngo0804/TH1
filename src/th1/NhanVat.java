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
public class NhanVat implements Serializable{
    private String ten;
    private int HP;
    private int ATK;
    private int DEF;
    private int speed;
    private int level;
    private LopNhanVat characterClass;
    private VuKhi weapon;
    private DanhSachLopNhanVat dslopnv;
    private DanhSachVuKhi dsvukhi;
    
    public NhanVat(DanhSachLopNhanVat dslopnv, DanhSachVuKhi dsvukhi) {
        ATK = 0;
        DEF = 0;
        HP = 0;
        characterClass = null;
        level = 0;
        speed = 0;
        ten = "";
        weapon = null;
        this.dslopnv = dslopnv;
        this.dsvukhi = dsvukhi;
        
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LopNhanVat getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(LopNhanVat characterClass) {
        this.characterClass = characterClass;
    }

    public VuKhi getWeapon() {
        return weapon;
    }

    public void setWeapon(VuKhi weapon) {
        this.weapon = weapon;
    }
    public void nhap() throws CloneNotSupportedException{
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ATK: ");
        setATK(Integer.parseInt(in.nextLine()));
        
        System.out.println("Nhap DEF: ");
        setDEF(Integer.parseInt(in.nextLine()));
        
        System.out.println("Nhap HP: ");
        setHP(Integer.parseInt(in.nextLine()));
        
        System.out.println("Nhap level: ");
        setLevel(Integer.parseInt(in.nextLine()));
        
        System.out.println("Nhap speed: ");
        setSpeed(Integer.parseInt(in.nextLine()));
        
        System.out.println("Chon ID lop nhan vat trong DS: ");
        dslopnv.xuat();
        int pos = dslopnv.FindByID(in.nextLine());
        while(pos == -1){
            System.err.println("Khong tim thay!!");
            pos = dslopnv.FindByID(in.nextLine());
        }
        
        characterClass = (LopNhanVat)dslopnv.getDS().get(pos).clone();
        
        System.out.println("Chon ID vu khi trong DS: ");
        dsvukhi.xuat();
        pos = dsvukhi.FindByID(in.nextLine());
        while(pos == -1){
            System.err.println("Khong tim thay!!");
            pos = dsvukhi.FindByID(in.nextLine());
        }
        weapon = (VuKhi)dsvukhi.getDS().get(pos).clone();
        
        System.out.println("Nhap ten NV: ");
        setTen(in.nextLine());
    }
    
    public void xuat(){
        System.out.println((char)27+"[34;43mTen: " + getTen());
        System.out.println((char)27+"[34;43mLevel: " + getLevel());
        System.out.println((char)27+"[34;43mATK: " + getATK());
        System.out.println((char)27+"[34;43mDEF: " + getDEF());
        System.out.println((char)27+"[34;43mHP: " + getHP());
        System.out.println((char)27+"[34;43mSpeed: " + getSpeed());
        getWeapon().xuat();
        getCharacterClass().xuat();
    }
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }
}
