/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provagithub;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francesco Cogliati
 */
public class MyThread extends Thread {
    //private String stringa;             //stringa dove devo cercare le vocali
    private char vocale;                //vocale da cercare
    private boolean usoYield;
    private boolean usoDelay;
    DatiCondivisi dati;
    /**
     * @author Francesco Cogliati
     * 
     * @brief costruttore vuoto.
     * @param stringa stringa che gli passiamo dal main, sarà uguale per tutti i thread
     * @param vocale vocale che gli passo nel main da trovare, sarà diversa per tutti i thread
    */
    public MyThread(char vocale, boolean yield, boolean delay, DatiCondivisi d){
            this.vocale = vocale;
            this.usoYield = yield;
            this.usoDelay = delay;
            this.dati = d;
    }
    /**
     * @author Francesco Cogliati
     * 
     * @brief metodo che viene runnato 
     */
    public void run(){
        /**
         * for che si ripete per la lunghezza della stringa e che ogni volta 
         * controlla se quel carattere è la mia vocale, se è lei la stampo e vado avanti,
         * se non è la mia vocale non gli faccio niente
         */
        for(int i = 0; i < dati.getStringa().length(); i++){
            try {
                if(dati.getStringa().charAt(i) == vocale){
                    System.out.println(vocale);
                    //dati.setVocale(vocale);
                }
                if(usoYield)
                    Thread.yield();
                if(usoDelay)
                    Thread.sleep(1000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
}
