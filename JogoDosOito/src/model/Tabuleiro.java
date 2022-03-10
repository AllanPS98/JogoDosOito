/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Allan Pereira
 */
public class Tabuleiro {
    private Celula[][] tabuleiro;

    public Tabuleiro() {
       this.tabuleiro = new Celula[3][3];
    }  
    
    public Celula[][] getTabuleiro() {
        return this.tabuleiro;
    }
    
    public void addCelula(Celula celula, int i, int j){
        this.tabuleiro[i][j] = celula;
    }
    
}
