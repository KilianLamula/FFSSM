/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package FFSSM;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;
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
public class MoniteurTest {
    
    private Moniteur m;
    private Club c;

    @BeforeEach
    public void setUp() {
        m = new Moniteur("AC34", "Matton", "Hugo", "ici", "0202020202", LocalDate.of(2001, Month.DECEMBER, 2), 1, GroupeSanguin.APLUS, 101);
        c = new Club(m, "club", "02020396802");
    }

    /**
     * Test of employeurActuel method, of class Moniteur.
     */
    @Test
    public void testEmployeurActuel() throws Exception {
        m.nouvelleEmbauche(c, LocalDate.now());
        assertEquals(c, m.employeurActuel().get(), "L'employeur n'est pas le bon");
    }

    //Test exception pas d'embauche
    @Test
    public void testEmployeurActuelException1() {
        try {
            // On créé un moniteur sans embauche
            // On s'attend à recevoir une exception
            m.employeurActuel();
            // Si on arrive ici, c'est une erreur, le test doit échouer
            fail("Un moniteur sans emploi doit générer une exception"); // Forcer l'échec du test			
        } catch (Exception e) {
            // Si on arrive ici, c'est normal, c'est le comportement attendu
        }
    }

    //Test exception pas d'embauche
    @Test
    public void testEmployeurActuelException2() {
        try {
            // On créé une embauche et on la termine directement
            m.nouvelleEmbauche(c, LocalDate.of(2001, Month.DECEMBER, 5));
            m.lesEmplois.get(0).terminer(LocalDate.now());
            // On s'attend à recevoir une exception
            m.employeurActuel();
            // Si on arrive ici, c'est une erreur, le test doit échouer
            fail("Un moniteur avec un emploi terminé doit générer une exception"); // Forcer l'échec du test			
        } catch (Exception e) {
            // Si on arrive ici, c'est normal, c'est le comportement attendu
        }
    }

}
