/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
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
public class ClubTest {
    
    private Plongeur p1, p2;
    private Moniteur m1, m2;
    private Club c;
    private Plongee pl1, pl2;
    private Site s;

    @BeforeEach
    public void setUp() {
        p1 = new Plongeur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.AMOINS);
        p2 = new Plongeur("AC35", "Bencharef", "Rayane", "ici1", "0203020202", LocalDate.of(2001, Month.DECEMBER, 5), 2, GroupeSanguin.BPLUS);

        m1 = new Moniteur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.APLUS, 101);
        m2 = new Moniteur("AC35", "Bencharef", "Rayane", "ici1", "0203020202", LocalDate.of(2001, Month.DECEMBER, 5), 2, GroupeSanguin.BMOINS, 122);

        c = new Club(m1, "club", "02020396802");

        s = new Site("Ici", "albi");

        pl1 = new Plongee(s, m1, LocalDate.of(2020, Month.MARCH, 2), 15, 3);
        pl2 = new Plongee(s, m1, LocalDate.of(2021, Month.AUGUST, 8), 10, 2);
    }

    /**
     * Test of plongeesNonConformes method, of class Club.
     */
    @Test
    public void testPlongeesNonConformes() {
        //On ajoute une licence valide à p1 et invalide à p2
        p1.ajouterLicence("HDG5", LocalDate.now(), c);
        p2.ajouterLicence("BAU6", LocalDate.of(2015, Month.MARCH, 6), c);
        
        //On ajoute les plongeurs aux plongées et on les organise
        pl1.ajouteParticipant(p1);
        c.organisePlongee(pl1);
        pl2.ajouteParticipant(p2);
        c.organisePlongee(pl2);
        
        //On vérifie que la liste retournée ne contient que la plongée invalide (pl2)
        assertTrue(c.plongeesNonConformes().contains(pl2) && !c.plongeesNonConformes().contains(pl1));
    }
    
}
