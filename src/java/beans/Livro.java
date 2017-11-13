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
public class Livro extends Item{
    
    public static final String volume = "15";
    public static final String preco = "80";

    public Livro() {
        super("Livro", 15, 80);
    }
    
}
