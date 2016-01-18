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
public class Discard {
    public List<Card> cards;

    public Discard() {
        cards = new LinkedList<Card>();
    }

    
    public Discard(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        this.cards.add(card);
    }
    
    
}
