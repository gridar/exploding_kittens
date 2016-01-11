/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Nicolas
 */
public class Deck {
    public static int NB_CARDS_BY_PLAYER = 9;
    public List<Card> cards;


    public float NB_ATTACK_CARDS = 4;
    public float NB_SKIP_CARDS = 4;
    public float NB_ATTACK_CARDS = 4;
    public float NB_ATTACK_CARDS = 4;
    public float NB_ATTACK_CARDS = 5;
    public float NB_ATTACK_CARDS = 20;
    
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
    public void distributeCards(List<Player> players, int nb_cards){
            for(int i = 0; i < players.size(); i++){
                for(int j=0; j <nb_cards; j++){
                    while(this.cards.get(0).name== "Exploding kitten"){
                        Collections.shuffle(this.cards);
                    }
                    players.get(i).cards.add(this.cards.get(0));
                    this.cards.remove(0);
                }
            }
    }
    
    
    
}
