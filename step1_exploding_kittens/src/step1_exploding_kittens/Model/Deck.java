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
    public static int NB_CARDS_BY_PLAYER = 52;
    public List<Card> cards;


    public int NB_ATTACK_CARDS = 4;
    public int NB_SKIP_CARDS = 4;
    public int NB_FAVOR_CARDS = 4;
    public int NB_SHUFFLE_CARDS = 4;
    public int NB_SEE_YHE_FUTURE_CARDS = 5;
    public int NB_DEFUSE_CARDS = 6;
    public int NB_NOPE_CARDS = 50;
    public int NB_KITTEN_CARDS = 20;
    
    public Deck(int nb_players) {
        this.cards = new LinkedList();
        int nb_exploding_kitten_cards = nb_players - 1;
        
        this.createCards("Exploding kitten", nb_exploding_kitten_cards);
        this.createCards("Attack", NB_ATTACK_CARDS);
        this.createCards("Skip", NB_SKIP_CARDS);
        this.createCards("Favor", NB_FAVOR_CARDS);
        this.createCards("Shuffle", NB_SHUFFLE_CARDS);
        this.createCards("See the future", NB_SEE_YHE_FUTURE_CARDS);
        this.createCards("Kitten", NB_KITTEN_CARDS);
        this.createCards("Nope", NB_NOPE_CARDS);
        this.createCards("Defuse", NB_DEFUSE_CARDS);
    }
    
    public void print() {
        for( int i = 0; i < cards.size(); i++) {
            System.out.println(cards.get(i).name);
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
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
                        this.shuffle();
                    }
                    players.get(i).cards.add(this.cards.get(0));
                    this.cards.remove(0);
                }
            }
    }

    public Card pick() {
        return this.cards.remove(0);
    }
    
    
    
}
