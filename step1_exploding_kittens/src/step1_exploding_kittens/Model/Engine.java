/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class Engine {
    public List<Player> players;
    public Deck deck;
    public Discard discard;
    
    public Engine() {
        deck = new Deck(2);
        
        players = new ArrayList();
        players.add(new Player( "nico"));
        players.add(new Player( "juju"));
        
        deck.print();
        System.out.println("\nrandomDeck ?\n");
        Collections.shuffle(deck.cards);
        deck.print();
        System.out.println("\nDistribute Cards ?\n");
        deck.distributeCards(players, 5);
        System.out.println("player 1");
        players.get(0).printCards();
        System.out.println("player 2");
        players.get(1).printCards();
        System.out.println("deck");
        deck.print();
        
        
        
        
    }
    
}
