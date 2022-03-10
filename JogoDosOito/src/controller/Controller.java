/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;
import model.Celula;
import model.Tabuleiro;

/**
 *
 * @author Allan Pereira
 */
public class Controller {

    public Controller() {
    }

    public Tabuleiro criarTabuleiro() {
        Random random = new Random();
        Tabuleiro tabuleiro = new Tabuleiro();
        inicializarTabuleiro(tabuleiro);
        for (int i = 0; i < tabuleiro.getTabuleiro().length; i++) {
            for (int j = 0; j < tabuleiro.getTabuleiro()[i].length; j++) {
                Integer valorInteiro;
                String valor;
                do {
                    valorInteiro = (Integer) random.nextInt(8) + 1;
                    valor = valorInteiro.toString();
                    if (i == tabuleiro.getTabuleiro().length - 1 && j == tabuleiro.getTabuleiro()[i].length - 1) {
                        valor = " ";
                        break;
                    }
                } while (contemCelula(valor, tabuleiro));
                tabuleiro.addCelula(new Celula(valor, i, j), i, j);
            }
        }
        return tabuleiro;
    }

    public void exibirTabuleiro(Tabuleiro tabuleiro) {
        for (Celula[] linha : tabuleiro.getTabuleiro()) {
            System.out.println("");
            for (Celula elemento : linha) {
                System.out.print(elemento.getValor() + " ");
            }
        }
        System.out.println("");
        System.out.println("-------------");
    }

    private void inicializarTabuleiro(Tabuleiro tabuleiro) {
        for (int i = 0; i < tabuleiro.getTabuleiro().length; i++) {
            for (int j = 0; j < tabuleiro.getTabuleiro()[i].length; j++) {
                tabuleiro.addCelula(new Celula(" ", i, j), i, j);
            }
        }
    }

    private boolean contemCelula(String valor, Tabuleiro tabuleiro) {
        for (Celula[] linha : tabuleiro.getTabuleiro()) {
            for (Celula elemento : linha) {
                if (valor.equals(elemento.getValor())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Tabuleiro moverParaCima(Tabuleiro tabuleiro) {
        Celula vazia = procurarVazio(tabuleiro);
        try {
            Celula aux = tabuleiro.getTabuleiro()[vazia.getPosicaoX() - 1][vazia.getPosicaoY()];
            aux.setPosicaoX(vazia.getPosicaoX());
            aux.setPosicaoY(vazia.getPosicaoY());
            tabuleiro.addCelula(aux, aux.getPosicaoX(), aux.getPosicaoY());
            vazia.setPosicaoX(vazia.getPosicaoX() - 1);
            vazia.setPosicaoY(vazia.getPosicaoY());
            tabuleiro.addCelula(vazia, vazia.getPosicaoX(), vazia.getPosicaoY());
        } catch (IndexOutOfBoundsException e) {

        }
        return tabuleiro;
    }

    public Tabuleiro moverParaBaixo(Tabuleiro tabuleiro) {
        Celula vazia = procurarVazio(tabuleiro);
        try {
            Celula aux = tabuleiro.getTabuleiro()[vazia.getPosicaoX() + 1][vazia.getPosicaoY()];
            aux.setPosicaoX(vazia.getPosicaoX());
            aux.setPosicaoY(vazia.getPosicaoY());
            tabuleiro.addCelula(aux, aux.getPosicaoX(), aux.getPosicaoY());
            vazia.setPosicaoX(vazia.getPosicaoX() + 1);
            vazia.setPosicaoY(vazia.getPosicaoY());
            tabuleiro.addCelula(vazia, vazia.getPosicaoX(), vazia.getPosicaoY());
        } catch (IndexOutOfBoundsException e) {

        }
        return tabuleiro;
    }

    public Tabuleiro moverParaEsquerda(Tabuleiro tabuleiro) {
        Celula vazia = procurarVazio(tabuleiro);
        try {
            Celula aux = tabuleiro.getTabuleiro()[vazia.getPosicaoX()][vazia.getPosicaoY() - 1];
            aux.setPosicaoX(vazia.getPosicaoX());
            aux.setPosicaoY(vazia.getPosicaoY());
            tabuleiro.addCelula(aux, aux.getPosicaoX(), aux.getPosicaoY());
            vazia.setPosicaoX(vazia.getPosicaoX());
            vazia.setPosicaoY(vazia.getPosicaoY() - 1);
            tabuleiro.addCelula(vazia, vazia.getPosicaoX(), vazia.getPosicaoY());
        } catch (IndexOutOfBoundsException e) {

        }
        return tabuleiro;
    }

    public Tabuleiro moverParaDireita(Tabuleiro tabuleiro) {
        Celula vazia = procurarVazio(tabuleiro);
        try {
            Celula aux = tabuleiro.getTabuleiro()[vazia.getPosicaoX()][vazia.getPosicaoY() + 1];
            aux.setPosicaoX(vazia.getPosicaoX());
            aux.setPosicaoY(vazia.getPosicaoY());
            tabuleiro.addCelula(aux, aux.getPosicaoX(), aux.getPosicaoY());
            vazia.setPosicaoX(vazia.getPosicaoX());
            vazia.setPosicaoY(vazia.getPosicaoY() + 1);
            tabuleiro.addCelula(vazia, vazia.getPosicaoX(), vazia.getPosicaoY());
        } catch (IndexOutOfBoundsException e) {

        }
        return tabuleiro;
    }

    public Celula procurarVazio(Tabuleiro tabuleiro) {
        for (Celula[] linha : tabuleiro.getTabuleiro()) {
            for (Celula elemento : linha) {
                if (elemento.getValor().equals(" ")) {
                    return elemento;
                }
            }
        }
        return new Celula("", 0, 0);
    }

    public Tabuleiro gabaritarFimDeJogo() {
        Tabuleiro gabarito = new Tabuleiro();
        Integer contador = 0;
        for (int i = 0; i < gabarito.getTabuleiro().length; i++) {
            for (int j = 0; j < gabarito.getTabuleiro()[i].length; j++) {
                contador += 1;
                String valor = contador.toString();
                if (i == gabarito.getTabuleiro().length - 1 && j == gabarito.getTabuleiro()[i].length - 1) {
                    valor = " ";
                }
                gabarito.addCelula(new Celula(valor, i, j), i, j);
            }
        }
        return gabarito;
    }

    public boolean compararTabuleiros(Tabuleiro tab1, Tabuleiro tab2) {
        for (int i = 0; i < tab1.getTabuleiro().length; i++) {
            for (int j = 0; j < tab1.getTabuleiro()[i].length; j++) {
                if (!(tab1.getTabuleiro()[i][j].getValor().equals(tab2.getTabuleiro()[i][j].getValor()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
