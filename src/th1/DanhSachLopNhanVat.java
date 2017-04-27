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
public class DanhSachLopNhanVat implements Serializable, Constants{
    private ArrayList<LopNhanVat> DS;
    private int SoLuong;
    
    
    
    public DanhSachLopNhanVat(){
        DS = new ArrayList<LopNhanVat>();
    }

    public ArrayList<LopNhanVat> getDS() {
        return DS;
    }

    public void setDS(ArrayList<LopNhanVat> DS) {
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
        System.out.println("Nhap so luong lop nhan vat: ");
        setSoLuong(in.nextInt());
        System.out.println("Nhap cac lop nhan vat: ");
       
        LopNhanVat tmp;
        for(int i=0;i<SoLuong;i++){
          System.out.println("Nhap lop nhan vat thu " + (i+1));
          tmp = new LopNhanVat();
          tmp.nhap();
          DS.add(tmp);
        }
        
        _export();
    }
    public void xuat(){
        System.out.println("Danh sach lop nhan vat: ");
        for(LopNhanVat l:DS){
            l.xuat();
            System.out.println("------------------");
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
            LopNhanVat a = DS.get(pos);
            a.xuat();
        }
    }
   
    public void _export(){
        WriteObject wo = new WriteObject();
        wo.serialize(this, DSLOPNV);
    }
}
