/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lamul
 */
public class PlongeeTest {
    
    private Plongeur p1, p2;
    private Moniteur m;
    private Club c;
    private Plongee pl;
    private Site s;

    @BeforeEach
    public void setUp() {
        p1 = new Plongeur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.AMOINS);
        p2 = new Plongeur("AC35", "Bencharef", "Rayane", "ici1", "0203020202", LocalDate.of(2001, Month.DECEMBER, 5), 2, GroupeSanguin.BPLUS);

        m = new Moniteur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.APLUS, 101);

        c = new Club(m, "club", "02020396802");

        s = new Site("Ici", "albi");

        pl = new Plongee(s, m, LocalDate.of(2021, Month.AUGUST, 8), 10, 2);
    }

    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConformeVrai() {
        //On ajoute une licence valide à p1 / On vérifie que la liste des plongeurs de la plongée est vide
        p1.ajouterLicence("1", LocalDate.now(), c);
        assertTrue(pl.lesParticipants.isEmpty());
        
        //On ajoute une plongée au club et on vérifie que la liste est non vide
        c.organisePlongee(pl);
        assertFalse(c.lesPlongees.isEmpty());
        
        //On ajoute p1 dans la liste et on vérifie que la liste n'est plus vide
        pl.ajouteParticipant(p1);
        assertFalse(pl.lesParticipants.isEmpty());
        
        //On vérifie que la plongée est conforme
        assertTrue(pl.estConforme());
    }
    
    /**
     * Test of estConforme method, of class Plongee.
     */
    @Test
    public void testEstConformeFaux() {
        //On ajoute une licence invalide à p2 / On vérifie que la liste des plongeurs de la plongée est vide
        p2.ajouterLicence("2", LocalDate.of(2017, Month.APRIL, 22), c);
        assertTrue(pl.lesParticipants.isEmpty());
        
        //On ajoute une plongée au club et on vérifie que la liste est non vide
        c.organisePlongee(pl);
        assertFalse(c.lesPlongees.isEmpty());
        
        //On ajoute p2 dans la liste et on vérifie que la liste n'est plus vide
        pl.ajouteParticipant(p2);
        assertFalse(pl.lesParticipants.isEmpty());
        
        //On vérifie que la plongée est non conforme 
        assertFalse(pl.estConforme());
    }
}
