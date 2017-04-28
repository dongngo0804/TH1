package th1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
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
        
        EThread eth = new EThread(dsnv2.getDS(), new ArrayList<QuaiVat>());
        EThread.ThreadNV thnv = new EThread(dsnv2.getDS(), new ArrayList<QuaiVat>()).ThreadNV(1);
        
//        QuaiVat q = new QuaiVat();
//        q.nhap();
//        
//        ChienTruong c = new ChienTruong(dsnv2.getDS().get(0),q);
    }
    
}

class EThread {
    private static ArrayList<NhanVat> a;
    private static ArrayList<QuaiVat> b;
    private static String status;
    public EThread(ArrayList<NhanVat> a, ArrayList<QuaiVat> b){
        status = "init";
        this.a = a;
        this.b = b;
    }
    
    public static void delay(int miliseconds) {

        try {

            Thread.sleep(miliseconds);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    class ThreadNV implements Runnable{
        int number;
        
        public ThreadNV(int number){
            this.number = number;
        }
        @Override
        public void run() {
            System.out.println("Thread NV started .....");
            System.out.println(status);
            status = "Nhan vat thu" + number + "tan cong";
            try {
                notifyAll();
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(EThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    class ThreadQV implements Runnable{
        int number;
        
        public ThreadQV(int number){
            this.number = number;
        }
        
        @Override
        public void run() {
             System.out.println("Thread QV started .....");
            System.out.println(status);
            status = "Quai vat thu" + number + "tan cong";
            try {
                notifyAll();
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(EThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}