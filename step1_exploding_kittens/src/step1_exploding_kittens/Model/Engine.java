/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nicolas
 */
public class Engine {
    public List<Player> players;
    public Deck deck;
    public Discard discard;
    public Player currentPlayer;
    public Player currentCounterPlayer;
    
    public Engine() {
        deck = new Deck(2);
        
        players = new ArrayList();
        players.add(new Player( "nico"));
        players.add(new Player( "juju"));
        currentPlayer = players.get(0);
        
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
        
        while(!endGame()){
            
        }
    }
    
    public boolean endGame(){
        for(Player item : players){
            if(item.cards.size()==0){
                return true;
            }
        }
        return false;
    }
    
    public void playTurn(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("player's turn : "+currentPlayer.name);
        System.out.println("Cards");
        for(int i=0; i < currentPlayer.cards.size(); i++){
            System.out.println(i+"- "+currentPlayer.cards.get(i).name+" _ effect : "+currentPlayer.cards.get(i).effect);
        }
        System.out.println("Play card ? card's number ?");  
        String card_play_number = scanner.nextLine();
        Card card_play=currentPlayer.cards.get(Integer.parseInt(card_play_number));
        //effect card
        
        Card counter_card = counterCardPlayers(0);
        if(counter_card != null){
            //effect counter card
            //battle counter card with currentPlayer and currentCounterPlayer
        }
        
    }
    
    public Player nextPlayer(){
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).name==currentPlayer.name){
                if(i ==players.size()-1){
                    return players.get(0);
                }else{
                    return players.get(i);
                }
            }
        }
        return currentPlayer;
    }
    
    public Card counterCardPlayers(int nCounter){
        Card card_tmp = new Card();
        
        do{
            currentCounterPlayer= nextCounterPlayer();
            if(currentCounterPlayer==null){
                //error
            }else{

            }
           card_tmp = counterCard(currentCounterPlayer); 
            if(card_tmp!=null){
                if(card_tmp.name.equals("Nope")){
                    counterCardPlayers(nCounter++);
                }
            } 
        }while(!currentPlayer.name.equals(currentCounterPlayer.name));
        
        return null;
    }
    public Card counterCard(Player player){
        Scanner scanner = new Scanner(System.in);        
        String card_play_number="";
        Card card_play=new Card();
        System.out.println(currentCounterPlayer.name+" counter play with a Nope card ?");
        for(int i=0; i < player.cards.size(); i++){
            System.out.println(i+"- "+player.cards.get(i).name+" _ effect : "+player.cards.get(i).effect);
        }
        System.out.println("Play card ? card's number or n ?");  
        card_play_number = scanner.nextLine();
        if(card_play_number.equals("n")){
            return null;
        }else{
            card_play= player.cards.get(Integer.parseInt(card_play_number));
            if(card_play.name.equals("Nope")){
                return card_play;
            }else{
                System.out.println("Wrong card play");
                counterCard(player);
            }
            
        }
        return null;
    }

    private Player nextCounterPlayer() {
        for (int i = 0; i < players.size(); i++) {
            if(players.get(i).equals(currentCounterPlayer.name)){
                if(i==players.size()-1){
                    currentCounterPlayer= players.get(0);
                }else{
                     currentCounterPlayer= players.get(i+1);
                }
                return currentCounterPlayer;
            }
        }
        return null;
    }
    
}
