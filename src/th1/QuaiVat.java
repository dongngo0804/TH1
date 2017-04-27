/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.util.Scanner;

/**
 *
 * @author dongnh
 */
public class QuaiVat implements Runnable{
    private String ten;
    private int hp;
    private int atk;
    private int def;
    private int atk_speed;

    public QuaiVat(){
        ten = "";
        hp = 0;
        atk = 0;
        def = 0;
        atk_speed = 0;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtk_speed() {
        return atk_speed;
    }

    public void setAtk_speed(int atk_speed) {
        this.atk_speed = atk_speed;
    }
    
    public void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ten quai vat: ");
        ten = in.nextLine();
        System.out.println("Nhap HP: ");
        hp = Integer.parseInt(in.nextLine());
        System.out.println("Nhap ATK: ");
        atk = Integer.parseInt(in.nextLine());
        System.out.println("Nhap DEF: ");
        def = Integer.parseInt(in.nextLine());
        System.out.println("Nhap ATK speed: ");
        atk_speed = Integer.parseInt(in.nextLine());
    }

    public void xuat(){
        System.out.println(this.toString());
    }
    @Override
    public String toString() {
        return ("Ten: " + ten + '\n' + "HP: " + hp + '\n' +
                "ATK: " + atk + '\n' + "DEF: " + def + '\n' +
                "ATK Speed: " + atk_speed);
    }

    @Override
    public void run() {
     System.out.println("atk");
    }
    public void start(){
        System.out.println("Starting");
        Thread t = new Thread(this,this.ten);
        t.start();
    }
}
