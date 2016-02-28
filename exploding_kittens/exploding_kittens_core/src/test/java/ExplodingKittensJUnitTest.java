/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.exploding_kittens_core.Model.Card;
import com.mycompany.exploding_kittens_core.Model.Deck;
import com.mycompany.exploding_kittens_core.Model.Player;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author julien
 */
public class ExplodingKittensJUnitTest {
    
    public ExplodingKittensJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testDeckInitialisation(){
        Deck deck = new Deck(2);
        assertThat(deck.cards.size()).isEqualTo(53);
    }
    
    @Test
    public void testDeckPickACard(){
        Deck deck = new Deck(2);
        deck.pick();
        assertThat(deck.cards.size()).isEqualTo(52);
    }
    
    @Test
    public void testPlayersHaveAName(){
        Player player = new Player("Player");
        assertThat(player.name).isEqualTo("Player");
    }
    
    @Test
    public void testPlayerIsAlive(){
        Player player = new Player("player");
        assertThat(player.state).isEqualTo("aLive");
    }
    
    @Test
    public void testPlayerCanPickACard(){
        Player player = new Player("player");
        player.cards.add(new Card("Kitten"));
        assertThat(player.haveSpecificCard("Kitten")).isEqualTo(true);
    }
    
    @Test
    public void testPlayerCanPlayACard(){
        Player player = new Player("player");
        player.cards.add(new Card("Kitten"));
        player.playSpecificCard("Kitten");
        assertThat(player.cards.size()).isEqualTo(0);
    }
    
    @Test
    public void testDeckDistributeCards(){
        List<Player> players = new LinkedList();
        players.add(new Player("julien"));
        players.add(new Player("Nico"));
        Deck deck = new Deck(2);
        deck.distributeCards(players, 10);
        assertThat(players.get(0).cards.size()).isEqualTo(10);
    }
}
