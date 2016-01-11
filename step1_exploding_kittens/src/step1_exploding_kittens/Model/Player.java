/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

import java.util.List;
import java.util.EmptyStackException;
import java.util.LinkedList;

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
}
