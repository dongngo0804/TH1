package th1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main implements Constants{
    
    
    
    public static void main(String[] args) throws CloneNotSupportedException {
        
        Scanner in = new Scanner(System.in);
        
        //Nhap danh sach lop nhan vat tu file
        DanhSachLopNhanVat dslopnv2 = new DanhSachLopNhanVat();
        ReadObject ro = new ReadObject();
        dslopnv2 = (DanhSachLopNhanVat)ro.deserializeObject(DSLOPNV);
        
        //Nhap danh sach vu khi tu file
        DanhSachVuKhi dsvukhi2 = (DanhSachVuKhi)ro.deserializeObject(DSVK);
        dsvukhi2.xuat();
        
//        DanhSachNhanVat dsnv = new DanhSachNhanVat(dslopnv2, dsvukhi2);
//        dsnv.nhap();
//        WriteObject wo = new WriteObject();
//        wo.serialize(dsnv, DSNV);
        //Nhap danh sach nhan vat tu file
        DanhSachNhanVat dsnv2 = (DanhSachNhanVat) ro.deserializeObject(DSNV);
        dsnv2.xuat();                                                                                                                           
        
        QuaiVat q = new QuaiVat();
        q.nhap();
        q.start();
        System.out.println("Tao nhan vat A");
       
    }
}
                                    