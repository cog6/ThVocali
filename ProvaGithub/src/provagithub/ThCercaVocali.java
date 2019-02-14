/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provagithub;

import java.util.Scanner;

/**
 *
 * @author Francesco Cogliati
 */
public class ThCercaVocali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        String stringa = "";
        String vUtente = "";
        
        Semafori semaforo = new Semafori(1);

        boolean delay = false;
        boolean yeld = false;

        int maxN = 0;
        String maxV = "";

        Scanner s = new Scanner(System.in);

        System.out.println("Immettere la frase: ");
        stringa = s.next();
        System.out.println("Qual'è la vocale che compare più volte nella frase?");
        vUtente = s.next();
        
        DatiCondivisi dati = new DatiCondivisi(stringa, semaforo);

        MyThread a = new MyThread('a', yeld, delay, dati);
        MyThread e = new MyThread('e', yeld, delay, dati);
        MyThread i = new MyThread('i', yeld, delay, dati);
        MyThread o = new MyThread('o', yeld, delay, dati);
        MyThread u = new MyThread('u', yeld, delay, dati);

        a.start();
        e.start();
        i.start();
        o.start();
        u.start();
        
        a.interrupt();
        e.interrupt();
        i.interrupt();
        o.interrupt();
        u.interrupt();

        a.join();
        e.join();
        i.join();
        o.join();
        u.join();

        if (maxN < dati.getA()) {
            maxN = dati.getA();
            maxV = "a";
        }
        if (maxN < dati.getE()) {
            maxN = dati.getE();
            maxV = "e";
        }
        if (maxN < dati.getI()) {
            maxN = dati.getI();
            maxV = "i";
        }
        if (maxN < dati.getO()) {
            maxN = dati.getO();
            maxV = "o";
        }
        if (maxN < dati.getU()) {
            maxN = dati.getU();
            maxV = "u";
        }
        
        if(vUtente == maxV){
            System.out.println("BRAVO HAI VINTO!!!");
        }else{
            System.out.println("Impara a contare e riprova a giocare!!");
        }
        System.out.println("La vocale più utilizzata è la lettera: " + maxV + ", che è stata utilizzata " + Integer.toString(maxN) + "volte.");
        System.out.println("Ciao alla prossima!");
    }

}
