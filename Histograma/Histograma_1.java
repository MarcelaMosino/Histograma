
package Histograma;

import java.util.*;
import javax.swing.*;;
import java.io.*;
import org.jfree.ui.RefineryUtilities;

public class Histograma_1 {
    Funciones funci = new Funciones(); 
    Arch ar = new Arch();
    double [] arreglazo;
//  double [] contadores;
//  double [] limiteClase;
//  double [] superiClase;
//  double [] marcaDeClase;
    int n, r, k, h;

    public void inicio(){
        JOptionPane.showMessageDialog(null,
            "El programa genera un histograma utilizando\n"
            +"valores aleatorios dado un numero de datos n","Bienvenido",1);
    }

    public int menuPrincipal(){
        String respuesta = "";
        String[] opciones = {"1. Alimentar datos por teclado", 
                        "2. Generar datos aleatoriamente",
                        "3. Alimentar por archivo",
                        "4. Salir"};
        int ret;

        respuesta = (String)JOptionPane.showInputDialog(null, "Que desea hacer?",
                        "Menu Principal", 3, null, opciones, opciones[1]);
        if(respuesta != null)	ret = Integer.parseInt(""+respuesta.charAt(0));		
        else			ret = 4;		
        return ret;
    }/*

    public void estableceLimites(){
        limiteClase = new double[(int)k];
        superiClase = new double[(int)k];
        marcaDeClase = new double[(int)k];

        limiteClase[0] = funci.min;
        for (int i = 1; i<k; i++)
            limiteClase[i] = limiteClase[i-1]+h;
        superiClase[0] = limiteClase[1];
        for (int i = 1; i<k; i++) 
            superiClase[i] = superiClase[i-1]+h;
        for (int i = 0; i<k; i++) 
            marcaDeClase[i] = (superiClase[i]+limiteClase[i])/2;
    }

    public void contar(){
        estableceLimites();
        contadores = new double[(int)k];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<k; j++){
                if(arreglazo[i]<superiClase[j]&&
                   arreglazo[i]>=limiteClase[j])
                    contadores[j]++;
            }
        }
    }*/

    public void flujo(int a)throws IOException{
        if(a!=3)
            n = funci.size = funci.numeroDeDatos();
        switch(a){
            case 1: arreglazo= funci.arregloAlimentado(); break;
            case 2: arreglazo= funci.arregloRandom(); break;
            case 3: arreglazo= funci.arregloArchivo(); break;
        }    
        r = funci.rango();
        k = funci.numeroDeClases();
        h = funci.anchoDeClase();
        if((h*k)<=funci.max)
                k++;
        //contar();
        Histogram histo = new Histogram("Histograma",arreglazo,k);
        histo.pack();
        RefineryUtilities.centerFrameOnScreen(histo);
        histo.setVisible(true);
    }

    public static void main(String[] args)throws IOException {
        Histograma_1 h = new Histograma_1();
        int opc;

        h.inicio();
        do{
            opc= h.menuPrincipal();
            System.out.println(opc);
            switch(opc){
                case 1: h.flujo(1); break;
                case 2: h.flujo(2); break;
                case 3: h.flujo(3); break;
                case 4: JOptionPane.showMessageDialog(null, "Hasta Luego",
                        "Fin de ejecucion",-1); break;
            }
        }while(opc!=4);
    } 
    
}
