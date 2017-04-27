/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dongnh
 */
public class WriteObject {

    private FileOutputStream fout;
    private ObjectOutputStream oos;

    public WriteObject() {
        fout = null;
        oos = null;
    }

    public void serialize(Object obj, String fileName) {
        System.out.println("Ghi ra file " + fileName + "......");
        _wait(2);
        try {
            fout = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(obj);
            
            System.out.println("Hoan tat!!!");

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void _wait(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException ex) {
            Logger.getLogger(WriteObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
