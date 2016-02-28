/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exploding_kittens_core.Model;


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
        discard = new Discard();
        Collections.shuffle(deck.cards);
        deck.distributeCards(players, 5);
        /*
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
        */
        
        currentPlayer = players.get(0);
        /*
        while(!endGame()){
            playTurn();
            nextPlayer();            
        }
        */
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
        // remove card from player hand
        Card played_card = currentPlayer.playSpecificCard(Integer.parseInt(card_play_number));
        System.out.println(played_card.name);
        
        if(!blocked()){
            System.out.println("Card not blocked");
            // do effect of the card
            played_card.play(this);
            played_card.goDiscard(this);
        }else{
            // put card in discard
            System.out.println("Card blocked");
            played_card.goDiscard(this);   
        }
        
        this.askForFinishTurn();
    }
    
    public void nextPlayer(){        
        int index = players.indexOf(currentPlayer);
        currentPlayer = this.players.get((index+1)%getNbPlayers());    
    }
    
    public void askForFinishTurn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Finish turn ? y / n");        
        switch (scanner.nextLine()) {
            case "n": 
                playTurn();
                break;
            case "y": 
                currentPlayer.cards.add(deck.pick());
                break;
            default: 
                askForFinishTurn();
                break;
        }
        
    }
    

    public boolean blocked(){
        return this.blocked(this.getCurrentPlayer());
    }
    public boolean blocked(Player player){

        boolean blocked = false;
        int index = getPlayerIndex(player);
        int tmp_index=0;
        int nbPlayer = this.getNbPlayers();

        // loop on all players starting with current player
        for(int i = index + 1; i < index + nbPlayer; i++) {
            tmp_index = i % nbPlayer;
            Player tmp_player = this.players.get(tmp_index);
            if(tmp_player.haveBlockCard() && tmp_player.selectBlockCard()){
                tmp_player.playSpecificCard("Nope").play(this);
                
                
                if(!blocked(tmp_player)){
                    blocked = true;
                    break;
                }
            }
        
        }
        return blocked;
    }

    public void goDiscard(Card card){
        
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    private int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }
    private int getPlayerIndexWithName(String playerName) {
        for(int i =0; i< this.players.size();i++){
            if(this.players.get(i).name.equals(playerName)){
                return i;
            }
        }
        return -1;
    }

    private int getNbPlayers() {
        return players.size();
    }
    
    public Engine EngineServlet(List<String> cardsPlay, Engine g){
        int index = 0;
        String player=null;
        String playerC=null;              
        String cardPlayed=null;
        String cardPlayedC=null;
        String[] tmp=new String[2];
        String[] tmpC=new String[2];
        int counterNope=0;
        boolean isCounter=false;
        int nope=0;
        int indexPlayer;
        
        
        for(int i=0; i< cardsPlay.size(); i++){
            tmp= cardsPlay.get(i).split("-");
            cardPlayed = tmp[0];
            player=tmp[1];
            
            index = i+1;
            while(index<cardsPlay.size()&& !isCounter ){
                tmpC= cardsPlay.get(index).split("-");
                cardPlayedC = tmpC[0];
                playerC=tmpC[1];
                
                if(!cardPlayedC.equals("Nope")){
                    if(counterNope==0){
                        isCounter = true;
                    }else{
                        i=index-1;
                        nope = counterNope%2;
                        isCounter = true;
                    }
                }else{
                    counterNope++;
                }
                
                index++;
            }
            
            
            if(nope==0){
                indexPlayer= g.getPlayerIndexWithName(player) ;
                if(indexPlayer!=-1){
                    Card tmpCard = g.players.get(indexPlayer).playSpecificCard(cardPlayed);
                    //tmpCard.play(g);
                    tmpCard.goDiscard(g);
                }
                
            }
        }
        g.currentPlayer.cards.add(g.deck.pick());
        g.nextPlayer(); 
        
        return g;
             
    }
    
}

