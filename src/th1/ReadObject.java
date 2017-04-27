/*
 * To change this license header, choise License Headers in Project Properties.
 * To change this template file, choise Tools | Templates
 * and open the template in the editor.
 */
package th1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dongnh
 */
public class ReadObject {
    private FileInputStream fin;
    private ObjectInputStream ois;

    public ReadObject() {
        fin = null;
        ois = null;
    }

    public Object deserializeObject(String fileName) {
        System.out.println("Doc file " + fileName + ".......");
        _wait(2);
        Object obj = null;
        try {
            fin = new FileInputStream(fileName);
            ois = new ObjectInputStream(fin);
            obj = ois.readObject();
            
            System.out.println("Hoan tat!!!");

        } catch (Exception ex) {
            
            ex.printStackTrace();
            
        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
       
        return obj;
    }
    public void _wait(int sec){
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException ex) {
            Logger.getLogger(WriteObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
