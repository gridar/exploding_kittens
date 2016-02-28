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
    public void une_partie_doit_etre_intialisee() throws Exception {
        assertEquals("Partie non initialisee", get(getServletUri()));
    }

    private String getServletUri() {
        return getBaseUri();
    }
}
