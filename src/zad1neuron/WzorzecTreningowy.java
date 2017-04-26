/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1neuron;

/**
 *
 * @author USER
 */
public class WzorzecTreningowy {
    private int N;
    private double wejscie[] = new double[N];
    private double zakladaneWyjscie;
    
    WzorzecTreningowy(int N, double[] wejscie, double proponowaneWyjscie) {
        this.N=N;
        this.wejscie=wejscie;
        this.zakladaneWyjscie=proponowaneWyjscie;
    }
   
    public int getN () {
        return N;
    }
    
    public double getWejscie (int i) {
        return wejscie[i];
    }
    
    public double getProponowaneWyjscie () {
        return zakladaneWyjscie;
    }
}
