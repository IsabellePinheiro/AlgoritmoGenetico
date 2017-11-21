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
public class MochilaDaoImpl implements MochilaDao {

    @Override
    public List<Mochila> initialize(List<Item> itens) {
        /*
        TODO:
        
        Criar 10 mochilas
        popular de maneira aleatória mochila.itens[] com os itens criados 
            0 -> item não está na mochila
            1 -> item está na mochila
        
        return lista de mochilas populadas
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int evaluate(Mochila mochila, int pontuacaoMaxima, int volumeMaximo) {
        /*
        TODO:
        
        Pontuação calculada baseada no volume ocupado e no maior preço possível
        PontuacaoVolume = (volume da mochila) - (volume ocupado) 
        PontuacaoPreco = (soma dos precos de todos os itens existentes) - (soma dos precos dos itens na mochila)
        
        Pontuação é calculada de maneira inversamente proporcional
        (quanto mais próximo de 0 (PontuacaoVolume + PontuacaoPreco) for mais próximo da pontuação máxima a pontuação calculada deve ser)
                
        retornar pontuação calculada
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mochila[] selection(List<Mochila> mochilas) {
        /**
         * criar array x = mochila[2];
         * Somar fitness de todas as mochilas
         * Criar array de mochilas do tamando da soma dos fitness
         * cada mochila vai ocupar y espaços do array onde y é o seu fitness
         * gerar numero aleatorio z sendo que z está entre 0 e soma dos fitness
         * 
         * z[0] = array de mochilas[z]
         * 
         * gerar numero aleatorio w sendo que w está entre 0 e soma dos fitness
         * se w = z gerar outro numero
         * x[1] = array de mochilas[w]
         * 
         * retornar x
         */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mochila> crossover(Mochila mochila1, Mochila mochila2) {
        /*
        TODO:
        
        Criar 10 novas mochilas a partir das 2 melhores da população anterior
        Gerar numero x aleatorio entre 0 e 1
        Se x <= 0.5, usar gene da mochila1
        Se x > 0.5, usar gene da mochila2
        
        retornar nova população
        */
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mochila> mutation(List<Mochila> mochila) {
        /*
        TODO:
        
        Escolher uma mochila aleatoria da população
        Escolher um gene aleatorio 
        0,001% de chance de alterar esse gene
        
        retornar mochila
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean stop(List<Mochila> mochilas, int nroGeracao, int pontuacaoMaxima) {
        /*
        TODO:
        
        
        Verificar 3 condições de parada
        1ª -> a população convergiu(Todos os cromossomos são iguais)
        2ª -> quando o “melhor” indivíduo foi encontrado (fitness = pontuação máxima)        
        3ª -> após um número N de gerações
        */
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
