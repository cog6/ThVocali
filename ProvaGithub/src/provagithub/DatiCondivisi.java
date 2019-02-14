/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provagithub;

/**
 *
 * @author cogliati_francesco
 */
public class DatiCondivisi {

    private int[] vocali = new int[5];
    
    private String stringa;
    private Semafori sem;

    public DatiCondivisi(String stringa, Semafori sem) {
        Riempi();

        this.stringa = stringa;
        this.sem = sem;
    }

    private void Riempi() {
        vocali[0] = 0;
        vocali[1] = 0;
        vocali[2] = 0;
        vocali[3] = 0;
        vocali[4] = 0;
    }

    public String getStringa() {
        return stringa;
    }

    public int getA() {
        return vocali[0];
    }

    public int getE() {
        return vocali[1];
    }

    public int getI() {
        return vocali[2];
    }

    public int getO() {
        return vocali[3];
    }

    public int getU() {
        return vocali[4];
    }

    /*public String vocaleMaggiore() {
        String stringa = "";
        int max = 0;        //max sarà uguale a 0, variabile che conterrà la vocale col numero più alto

        //for per determinare la vocale con il numero più alto
        for (int i = 0; i < 5; i++) {
            if(max < vocali[i])
                max = vocali[i];
        }
        
        return stringa;
    }*/
    public void setVocale(char vocale) {
        switch (vocale) {
            case 'a':
                vocali[0] = vocali[0] + 1;
                break;
            case 'e':
                vocali[1] = vocali[1] + 1;
                break;
            case 'i':
                vocali[2] = vocali[2] + 1;
                break;
            case 'o':
                vocali[3] = vocali[3] + 1;
                break;
            case 'u':
                vocali[4] = vocali[4] + 1;
                break;
        }
    }
}
