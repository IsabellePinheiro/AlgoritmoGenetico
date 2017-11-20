/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author arthur.sens
 */
public class Mochila {

    private Integer volume;
    private int[] itens;
    private int fitness;
    /**
     * Pontuação é calculada através
     */
    private int pontuacaoMaxima;

    public Mochila(Integer volume, int[] itens) {
        this.volume = volume;
        this.itens = itens;
        this.CalcularPontuacaoMaxima();
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public int[] getItens() {
        return itens;
    }

    public void setItens(int[] itens) {
        this.itens = itens;
    }

    public int getFitness() {
        return fitness;
    }

    public int getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }

    public void setPontuacaoMaxima(int pontuacaoMaxima) {
        this.pontuacaoMaxima = pontuacaoMaxima;
    }

    private void CalcularPontuacaoMaxima(){
        //TODO:
    }
}
