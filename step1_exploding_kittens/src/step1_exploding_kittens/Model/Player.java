/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

import java.util.List;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Player {
    public String name;
    public String state;
    public List<Card> cards;
    

    public Player() {
        throw new EmptyStackException();
    }

    public Player(String name) {
        this.name = name;
        this.state = "aLive";
        this.cards = new LinkedList();
    }
    
    
    public Player(String name, String state, List cards) {
        this.name = name;
        this.state = state;
        this.cards = cards;
    }

    public void printCards(){
        for(Card item : cards){
            System.out.println(item.name);
        }
    }
    
    public boolean haveSpecificCard(String name){
        for(Card item : this.cards){
            if(item.getName()==name){
                return true;
            }
        }
        return false;
    }
    
    public Card getSpecificCard(String name){
        for(Card item : this.cards){
            if(item.getName()==name){
                return item;
            }
        }
        return null;
    }

    public boolean haveSpecificPairs(String name){
        if (cards.stream().filter(c -> c.name.equals(name)).count() == 2) {
            return true;
        }
        return false;
    }
    
    public Card playCard(int index){
        Card card_tmp = new Card();
        card_tmp = this.cards.get(index);
        this.cards.remove(index);
        
        return card_tmp;
    }

    boolean haveBlockCard() {
        return haveSpecificCard("Nope");
    }

    public boolean selectBlockCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.name + " Play Nope card ? y or n ?");
        switch (scanner.nextLine()) {
            case "y": return true;
            case "n": return false;
            default: return selectBlockCard();
        }
    }

    public Card playSpecificCard(String name) {
        Card tmp_card= getSpecificCard(name);
        this.cards.remove(tmp_card);
        return tmp_card;
    }
    
    public Card playSpecificCard(int index) {
        Card tmp_card= this.cards.get(index);
        this.cards.remove(tmp_card);
        return tmp_card;
    }
    
}
