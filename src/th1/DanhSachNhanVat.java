/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dongnh
 */
public class DanhSachNhanVat implements Serializable, Constants{
    private ArrayList<NhanVat> DS;
    private int SoLuong;
    private DanhSachLopNhanVat dslopnv;
    private DanhSachVuKhi dsvukhi;
    
    public DanhSachNhanVat(DanhSachLopNhanVat dslopnv, DanhSachVuKhi dsvukhi){
        SoLuong = 0;    
        this.dslopnv = dslopnv;
        this.dsvukhi = dsvukhi;
        DS = new ArrayList<NhanVat>();
    
    }
    public ArrayList<NhanVat> getDS() {
        return DS;
    }
    public void setDS(ArrayList<NhanVat> DS) {
        this.DS = DS;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    public void nhap() throws CloneNotSupportedException{
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap so luong nhan vat: ");
        setSoLuong(Integer.parseInt(in.nextLine()));
        
        NhanVat tmp;
        for(int i=1;i<=SoLuong; i++){
            System.out.println("Nhap nhan vat thu "+ i);
            tmp = new NhanVat(dslopnv, dsvukhi);
            tmp.nhap();
            DS.add(tmp);
        }
        _export();
    }
    public void xuat(){
        System.out.println("Danh sach Nhan Vat: ");
        for(NhanVat a: DS){
            a.xuat();
            System.out.println("--------------------");
        }
    }
    public int FindByTen(String ten){
        for(int i = 0; i < DS.size(); i++ ){
            if (DS.get(i).getTen().equals(ten)){
                return i;
            }
        }
        return -1;
    }
    
    public void PrintByTen(String ten){
        int pos = FindByTen(ten);
        if (pos == -1){
            System.out.println("Khong tim thay nhan vat trong DS");
        }
        else{
            NhanVat a = DS.get(pos);
            a.xuat();
        }
    }
    public void addHead(NhanVat a){
        DS.add(0,a);
        _export();
    }
    public void addTail(NhanVat b){
        DS.add(b);
        _export();
    }
    public void edit(int pos) throws CloneNotSupportedException{
        DS.get(pos).nhap();
        _export();
    }
    public void delete(int pos){
        DS.remove(pos);
        _export();
    }
    public void sort(){
        DS.sort((o1, o2) -> o1.getTen().compareTo(o2.getTen()));
        _export();
    }
    public void _export(){
        WriteObject wo = new WriteObject();
        wo.serialize(this, DSNV);
    }
}
