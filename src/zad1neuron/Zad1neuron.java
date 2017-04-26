/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1neuron;

import java.util.List;


/**
 *
 * @author USER
 */
public class Zad1neuron {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int N = 4;                                                  //ilosc wejsc/wag
        int K=1000000;                                              //ilosc epok
        int iloscWzorcow = 4;                                       //ilosc wszystkich training pattern
        double[] obliczoneWyjscie = new double[iloscWzorcow];
        double delta;
        
        
        WzorzecTreningowy t1 = new WzorzecTreningowy (N,new double[] {1,2,3,4},1);
        WzorzecTreningowy t2 = new WzorzecTreningowy (N,new double[] {2,5,8,7},5);
        WzorzecTreningowy t3 = new WzorzecTreningowy (N,new double[] {8,1,3,5},2);
        WzorzecTreningowy t4 = new WzorzecTreningowy (N,new double[] {2,1,3,6},3.5);
        
        WzorzecTreningowy[] wzorce = new WzorzecTreningowy[] {t1,t2,t3,t4};
        
        neuron n1 = new neuron(); 
        n1.losuj(N);               
        
        for (int i=0; i < K; i++){
            for (int j=0; j < iloscWzorcow; j++ ) {
                obliczoneWyjscie[j] = n1.obliczWyjscie(wzorce[j]);
                delta = n1.obliczBlad(obliczoneWyjscie[j], wzorce[j]);
                n1.poprawWagi(delta,wzorce[j]);
 
            }
        }
        
        
        
        System.out.println("WAGI OSTATECZNE");
        double[] wagi = n1.getW();
        for (int i=0; i < N; i++ ){
            System.out.println(wagi[i]);
        }
        
        System.out.println();
        System.out.println("Obliczone Wyjscie          Proponowane wyjscie");
        for (int j=0; j < iloscWzorcow; j++ ) {
            
            System.out.print(obliczoneWyjscie[j]);
            System.out.print("          ");
            System.out.println(wzorce[j].getProponowaneWyjscie());
            
        }
             
    }
    
}
