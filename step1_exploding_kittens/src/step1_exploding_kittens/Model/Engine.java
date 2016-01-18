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
        System.out.println("player's turn : " + currentPlayer.name);
        System.out.println("Cards");
        for(int i=0; i < currentPlayer.cards.size(); i++){
            System.out.println(i + "- " + currentPlayer.cards.get(i).name + " _ effect : " + currentPlayer.cards.get(i).effect);
        }
        System.out.println("Play card ? card's number ?");  
        String card_play_number = scanner.nextLine();
        Card card_play = currentPlayer.cards.get(Integer.parseInt(card_play_number));
        //effect card
        System.println(card_play.name);
        
        if(!blocked()){
            card_play.play();
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

    public boolean blocked(){
        return this.blocked(this.getCurrentPlayer());
    }
    public boolean blocked(Player player){

        boolean blocked = false;
        int index = getPlayerIndex(player);
        int nbPlayer = this.getNbPlayers();

        // loop on all players starting with current player
        for(int i = index; i < index + nbPlayer ; i++) {
            tmp_index = i % nbPlayer;
            Player tmp_tmp_player = this.tmp_players.get(tmp_index);
            if(tmp_player.haveBlockCard() && tmp_player.selectBlockCard()){
                if(!blocked(tmp_player)){
                    blocked = true;
                    break;
                }
            }
        
        }
        return blocked;
    }

    public boolean selectBlockCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Play Nope card ? y or n ?");
        switch (scanner.nextLine()) {
            case "y": return true;
                break;
            case "n": return false;
                break;
            default: return selectBlockCard();
                break;
        }
    }

    Object getCurrentPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
