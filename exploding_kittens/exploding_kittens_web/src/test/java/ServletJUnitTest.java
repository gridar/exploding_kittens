/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julien
 */
public class ServletJUnitTest extends JettyHarness {
    
    public ServletJUnitTest() {
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

    @Test
    public void displayHandelingPage() throws Exception {
        String resp = get(getBaseUri());
        assertEquals(resp.contains("LoadGame"), true);
    }
    
    @Test
    public void twoPlayerExsits() throws Exception {
        String resp = get(getBaseUri());
        resp = get(getNewGameUri());
        assertEquals(resp.contains("nico"), true);
    }

    private String getNewGameUri() {
        return getBaseUri() + "game/new";
    }
}
