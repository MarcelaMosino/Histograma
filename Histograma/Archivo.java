package MotorPseudoAleatorio;

import javax.swing.*;
import java.io.*;

public class Archivo {
    File f1, f;
    String nombre;
    Validacion v = new Validacion();
    
    public void escribir(String c)throws IOException{
        nombre = JOptionPane.showInputDialog("Nombre del archivo "
                +"en que se guardaran los numeros generados");
        f1 = new File(nombre);         
        int r;
        
        if(f1.exists()){
            r = v.pregunta("Sobreescribir archivo");
            if(r == 0)
                f1.delete();
            else 
                nombre = nombreNuevo();
        } 
        f = new File(nombre);
        escribeArchivo(c);
    }
    
    public void escribeArchivo(String c)throws IOException{
        FileWriter fw = new FileWriter(f); fw.flush();
        BufferedWriter bw = new BufferedWriter(fw);
        
        
        fw.write(c);
        fw.close();
    }
    
    public String nombreNuevo(){
        String n;
        do{
            n = JOptionPane.showInputDialog("Nombre del nuevo archivo");
            f1 = new File(n);
        } while(f1.exists());
        return n;
    }
}
