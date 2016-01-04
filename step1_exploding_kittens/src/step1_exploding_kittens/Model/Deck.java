/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nicolas
 */
public class Deck {
    public static int NB_CARDS_BY_PLAYER = 10;
    public List<Card> cards;
    
    public Deck(int nb_players) {
        this.cards = new LinkedList();
        int nb_exploding_kitten_cards = nb_players - 1;
        int nb_normal_cards = nb_players * NB_CARDS_BY_PLAYER - nb_exploding_kitten_cards;
        
        
        this.createCards("Exploding kitten", nb_exploding_kitten_cards);
        this.createCards("kitten", nb_normal_cards);
    }
    
    public void print() {
        for( int i = 0; i < cards.size(); i++) {
            
            System.out.println(cards.get(i).name);
    
        }
    }
    
    private void createCards(String exploding_kitten, int nb_cards) {
        for(int i = 0; i < nb_cards; i++){
            this.cards.add(new Card(exploding_kitten));
        }
    }
    
    
    
}