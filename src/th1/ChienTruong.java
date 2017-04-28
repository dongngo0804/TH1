/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dongnh
 */
public class ChienTruong {
    NhanVat nv;
    QuaiVat q;    
    public ChienTruong(NhanVat nv, QuaiVat q){
        this.nv = nv;
        this.q = q;
    }
    
    synchronized void NhanVatATK(){
       while(true){
       System.out.println("Nhan vat tan cong");
        try {
            wait();
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
       }
    }
    synchronized void QuaiVatATK(){
       while(true){
       System.out.println("Quai vat tan cong");
       notify();
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(ChienTruong.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
    
}
