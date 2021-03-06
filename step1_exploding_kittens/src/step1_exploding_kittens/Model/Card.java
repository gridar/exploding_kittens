/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package step1_exploding_kittens.Model;

/**
 *
 * @author Nicolas
 */
public class Card {
    public String name;
    public String effect;

    public Card() {
        
    }

    public Card(String name) {
        this.name = name;
    }
    
    public Card(String name, String effect) {
        this.name = name;
        this.effect = effect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void play(Engine engine) {
        switch (this.name) {
//            case "Exploding kitten": engine.getCurrentPlayer().kill();
//                break;
//            case "Attack": engine.nextPlayer(); //to change
//                break;
//            case "Skip": engine.nextPlayer();
//                break;
//            case "Favor": engine.getCurrentPlayer().stealCard();
//                break;
//            case "Shuffle": engine.deck.shuffle();
//                break;
//            case "See the future": engine.deck.getNextCards(3);
//                break;
//            case "Kitten": 
//                if (engine.getCurrentPlayer().haveSpecificPairs(this.name))
//                    engine.getCurrentPlayer().stealCard();
//                break;  
//            case "Nope": this.goDiscard(engine);
//                break;
//            case "Defuse": throw UnimplementedCardPlayed();
//                break;
        }


    }

    public void goDiscard(Engine engine) {
        //engine.currentPlayer.cards.remove(this);
        engine.discard.add(this);
    }

    
    
    
}
