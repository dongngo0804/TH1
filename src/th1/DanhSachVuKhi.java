/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author ngohu
 */
public class DanhSachVuKhi implements Serializable, Constants{
    
    private ArrayList<VuKhi> DS;
    private int SoLuong;
    
    
    public DanhSachVuKhi() {
        DS = new ArrayList<VuKhi>();
        
    }

    public ArrayList<VuKhi> getDS() {
        return DS;
    }

    public void setDS(ArrayList<VuKhi> DS) {
        this.DS = DS;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
    public void nhap(){
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so luong vu khi: ");
        setSoLuong(in.nextInt());
        VuKhi tmp;
        for(int i = 0; i < SoLuong; i++){
            System.out.println("Nhap vu khi thu " + (i+1)+": ");
            tmp = new VuKhi();
            tmp.nhap();
            DS.add(tmp);
        }
        _export();
    }
    
    public void xuat(){
        System.out.println("Danh sach vu khi: ");
        for(VuKhi a: DS){
            a.xuat();
            System.out.println("--------------------");
        }
    }
    
    public int FindByID(String ID){
        for(int i = 0; i < DS.size(); i++ ){
            if (DS.get(i).getID().equals(ID)){
                return i;
            }
        }
        return -1;
    }
    
    public void PrintByID(String ID){
        int pos = FindByID(ID);
        if (pos == -1){
            System.out.println("Khong tim thay vu khi trong DS");
        }
        else{
            VuKhi a = DS.get(pos);        
            a.xuat();
        }
    }
    public void _export(){
        WriteObject wo = new WriteObject();
        wo.serialize(this, DSVK);
    }
    
}
