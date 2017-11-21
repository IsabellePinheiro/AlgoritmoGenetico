/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Item;
import beans.Mochila;
import java.util.List;

/**
 *
 * @author arthur.sens
 */
public interface MochilaDao {

    public List<Mochila> initialize(List<Item> itens);

    public int evaluate(Mochila mochila, int pontuacaoMaxima, int volumeMaximo);

    public Mochila[] selection(List<Mochila> mochilas);

    public List<Mochila> crossover(Mochila mochila1, Mochila mochila2);

    public List<Mochila> mutation(List<Mochila> mochila);

    public boolean stop(List<Mochila> mochilas, int nroGeracao, int pontuacaoMaxima);
}
