/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.Controller;
import model.Celula;
import model.Tabuleiro;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Allan Pereira
 */
public class TestJogoDosOito {
    
    private Controller controller;
    
    @Before
    public void setUp() {
        controller = new Controller();
    }
    
    @Test
    public void testMoverParaCima(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaCima(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(1, vazia.getPosicaoX());
        assertEquals(2, vazia.getPosicaoY());
    }
    
    @Test
    public void testNaoMoverParaCima(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaCima(tab);
        controller.moverParaCima(tab);
        controller.moverParaCima(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(0, vazia.getPosicaoX());
        assertEquals(2, vazia.getPosicaoY());
    }
    
    @Test
    public void testMoverParaBaixo(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaCima(tab);
        controller.moverParaBaixo(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(2, vazia.getPosicaoX());
        assertEquals(2, vazia.getPosicaoY());
    }
    
    @Test
    public void testNaoMoverParaBaixo(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaBaixo(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(2, vazia.getPosicaoX());
        assertEquals(2, vazia.getPosicaoY());
    }
    
    @Test
    public void testMoverParaEsquerda(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaEsquerda(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(2, vazia.getPosicaoX());
        assertEquals(1, vazia.getPosicaoY());
    }
    
    @Test
    public void testNaoMoverParaEsquerda(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaEsquerda(tab);
        controller.moverParaEsquerda(tab);
        controller.moverParaEsquerda(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(2, vazia.getPosicaoX());
        assertEquals(0, vazia.getPosicaoY());
    }
    
    @Test
    public void testMoverParaDireita(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaEsquerda(tab);
        controller.moverParaDireita(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(2, vazia.getPosicaoX());
        assertEquals(2, vazia.getPosicaoY());
    }
    
    @Test
    public void testNaoMoverParaDireita(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaDireita(tab);
        Celula vazia = controller.procurarVazio(tab);
        assertEquals(2, vazia.getPosicaoX());
        assertEquals(2, vazia.getPosicaoY());
    }
    
    @Test
    public void testJogoEmAndamento(){
        Tabuleiro tab = controller.criarTabuleiro();
        controller.moverParaEsquerda(tab);
        Tabuleiro gab = controller.gabaritarFimDeJogo();
        boolean isGameOver = controller.compararTabuleiros(gab, tab);
        assertEquals(false, isGameOver);
    }
    
    @Test
    public void testFimDeJogo(){
        Tabuleiro tab = controller.gabaritarFimDeJogo();
        Tabuleiro gab = controller.gabaritarFimDeJogo();
        boolean isGameOver = controller.compararTabuleiros(gab, tab);
        assertEquals(true, isGameOver);
    }
    
}
