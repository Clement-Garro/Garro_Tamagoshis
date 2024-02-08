import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class PileTests {

    private Pile pile;

    @BeforeEach
    void setUp() {
        pile = new Pile();
    }

    @Test
    void testEmpilerEtDepiler() {
        pile.empiler("element1");
        pile.empiler(2);
        assertEquals(2, pile.depiler());
        assertEquals("element1", pile.depiler());
    }

    @Test
    void testSommet() {
        pile.empiler("element1");
        pile.empiler(2);
        assertEquals(2, pile.sommet());
        pile.depiler();
        assertEquals("element1", pile.sommet());
    }

    @Test
    void testEstVide() {
        assertTrue(pile.estVide());
        pile.empiler("element1");
        assertFalse(pile.estVide());
    }

    @Test
    void testTaille() {
        assertEquals(0, pile.taille());
        pile.empiler("element1");
        pile.empiler(2);
        assertEquals(2, pile.taille());
        pile.depiler();
        assertEquals(1, pile.taille());
    }

    @Test
    void testDepilerVide() {
        assertThrows(NoSuchElementException.class, () -> pile.depiler());
    }
}
