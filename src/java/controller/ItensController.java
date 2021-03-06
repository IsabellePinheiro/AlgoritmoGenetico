/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Caderno;
import beans.Caneta;
import beans.Item;
import beans.Livro;
import beans.Mochila;
import beans.Penal;
import dao.MochilaDao;
import dao.MochilaDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ItensController {

    private List<Item> itens;
    private int qtdItens;
    private List<String> itensString;
    private final MochilaDao mochilaDao = new MochilaDaoImpl();
    private List<Mochila> populacao;
    private int volumeMaximo;
    private boolean mostraSolucionar;

    public List<Item> getItens() {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }

    public List<String> getItensString() {
        if (itensString == null) {
            itensString = new ArrayList<>();
        }
        return itensString;
    }

    public void setItensString(List<String> itensString) {
        this.itensString = itensString;
    }

    public int getVolumeMaximo() {
        return volumeMaximo;
    }

    public void setVolumeMaximo(int volumeMaximo) {
        this.volumeMaximo = volumeMaximo;
    }

    public boolean isMostraSolucionar() {
        return mostraSolucionar;
    }

    public void setMostraSolucionar(boolean mostraSolucionar) {
        this.mostraSolucionar = mostraSolucionar;
    }

    public void gerarItens() {
        itens = new ArrayList<>();
        int random;
        for (int i = 0; i < qtdItens; i++) {
            random = (int) (Math.random() * 4);
            switch (random) {
                case 0:
                    itens.add(new Caneta());
                    break;
                case 1:
                    itens.add(new Caderno());
                    break;
                case 2:
                    itens.add(new Livro());
                    break;
                case 3:
                    itens.add(new Penal());
                    break;
            }
        }
        gerarItensString();
        mostraSolucionar = true;
        
        volumeMaximo = (int) (Math.random() * 50) + 50;
    }

    private void gerarItensString() {
        int countCaderno = 0;
        int countCaneta = 0;
        int countLivro = 0;
        int countPenal = 0;
        for (Item item : itens) {
            if (item instanceof Caderno) {
                countCaderno++;
            }
            if (item instanceof Caneta) {
                countCaneta++;
            }
            if (item instanceof Livro) {
                countLivro++;
            }
            if (item instanceof Penal) {
                countPenal++;
            }
        }
        itensString.add(countCaderno + " Caderno(s) -     Preço individual: " + Caderno.preco + "     Volume individual: " + Caderno.volume);
        itensString.add(countCaneta + " Caneta(s) -     Preço individual: " + Caneta.preco + "     Volume individual: " + Caneta.volume);
        itensString.add(countLivro + " Livro(s) -     Preço individual: " + Livro.preco + "     Volume individual: " + Livro.volume);
        itensString.add(countPenal + " Penal(s) -     Preço individual: " + Penal.preco + "     Volume individual: " + Penal.volume);
        itensString.add("Volume da Mochila: " + volumeMaximo);
    }

    public void solucionar() {
        int nroGeracao = 1;
        int pontuacaoMaxima = calculaPontuacaoMaxima();
        Mochila[] melhores;
        populacao = mochilaDao.initialize(itens);
        populacao.forEach((mochila) -> {
            mochila.setFitness(mochilaDao.evaluate(mochila, pontuacaoMaxima, volumeMaximo));
        });

        while (!mochilaDao.stop(populacao, nroGeracao, pontuacaoMaxima)) {
            nroGeracao++;
            melhores = mochilaDao.selection(populacao);
            populacao = mochilaDao.crossover(melhores[0], melhores[1]);
            populacao = mochilaDao.mutation(populacao);
            populacao.forEach((mochila) -> {
                mochila.setFitness(mochilaDao.evaluate(mochila, pontuacaoMaxima, volumeMaximo));
            });
        }
    }

    private int calculaPontuacaoMaxima() {
        int preco = 0;
        for (Item item : itens) {
            preco += item.getPreco();
        }
        return preco + volumeMaximo;
    }

}
