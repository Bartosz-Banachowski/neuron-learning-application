/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1neuron;

import java.util.Random;

/**
 *
 * @author USER
 */
  public class neuron {
 
        private double []wagi = new double [4];
        private double wspolczynnikNauki=0.0001;
        private double z; //wartosc przewidywana
       
       
        
        public double obliczWyjscie( WzorzecTreningowy t) {
           double wynik=0;
           for (int i=0; i < t.getN(); i++)
               wynik+=wagi[i]*t.getWejscie(i);
           return wynik;
        }
        
        public double obliczBlad (double obliczoneWyjscie, WzorzecTreningowy t ) {
            double delta=0;
            delta = t.getProponowaneWyjscie()-obliczoneWyjscie;
            return delta;
        }
     
        public void poprawWagi( double delta, WzorzecTreningowy t) { 
            for (int i=0; i < t.getN(); i++)
                {
                    wagi[i] = wagi[i] + wspolczynnikNauki*delta*t.getWejscie(i);
                }
        }
         
        public void losuj ( int n) {
            Random generator = new Random();
            for (int i=0; i < n; i++)
                wagi[i] = generator.nextDouble()*2;
        }
          
        public double getZ() {
              return z;
        }
        
        public double[] getW () {
              return wagi;
          }
    }
