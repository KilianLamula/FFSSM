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
public class LicenceTest {

    private Plongeur p1, p2;
    private Moniteur m;
    private Club c;
    private Licence l1, l2;

    @BeforeEach
    public void setUp() {
        p1 = new Plongeur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.AMOINS);
        p2 = new Plongeur("AC35", "Bencharef", "Rayane", "ici1", "0203020202", LocalDate.of(2001, Month.DECEMBER, 5), 2, GroupeSanguin.BPLUS);

        m = new Moniteur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.APLUS, 101);

        c = new Club(m, "club", "02020396802");

        l1 = new Licence(p1, "HDG5", LocalDate.of(2015, Month.MARCH, 6), c);
        l2 = new Licence(p2, "BAU6", LocalDate.of(2021, Month.OCTOBER, 1), c);
    }

    /**
     * Test of estValide method, of class Licence.
     */
    @Test
    public void testEstValideFalse() {
        //l1 est une license invalide à la date d'aujourd'hui, on vérifie que EstValide retourne False :
        assertFalse(l1.estValide(LocalDate.now()));
    }
    
    @Test
    public void testEstValideTrue() {
        //l2 est une license valide à la date d'aujourd'hui, on vérifie que EstValide retourne False :
        assertTrue(l2.estValide(LocalDate.now()));
    }
}
