import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class EnsembleTests {

    Ensemble a;
    Ensemble b;
    Ensemble c;
    Ensemble d;

    EnsembleTests() {
        a = new Ensemble(); // {}
        ArrayList<Object> elements = new ArrayList<>();
        elements.add("b");
        b = new Ensemble(elements); // {"b"}
        elements.remove("b");
        elements.add(2.0);
        elements.add("a");
        elements.add(3);
        c = new Ensemble(elements); // {2.0, "a", 3}
        elements.add(2.0);
        d = new Ensemble(elements); // {2.0, "a", 3}
    }

    @Test
    void testConstructeur() {
        ArrayList<Object> elements = new ArrayList<>();
        elements.add(null);
        assertThrows(NullPointerException.class, () -> new Ensemble(elements));
        elements.add(0, "b");
        assertThrows(NullPointerException.class, () -> new Ensemble(elements));
    }

    @Test
    void testTaille() {
        assertEquals(0, a.taille());
        assertEquals(1, b.taille());
        assertEquals(3, c.taille());
        assertEquals(3, d.taille());
    }

    @Test
    void testContient() {
        assertFalse(a.contient(1));
        assertFalse(b.contient(1));
        assertTrue(b.contient("b"));
        assertFalse(c.contient(0));
        assertTrue(c.contient(2.0));
        assertFalse(d.contient(0));
        assertTrue(d.contient(2.0));
    }

    @Test
    void testElement() {
        assertThrows(NoSuchElementException.class, () -> a.element());
        assertEquals("b", b.element());
        assertTrue(c.contient(c.element()));
        assertTrue(d.contient(d.element()));
    }

    @Test
    void testUnion() {
        Ensemble e = b.union(c);
        assertEquals(4, e.taille());
        assertTrue(e.contient("b"));
        assertTrue(e.contient(3));
        assertFalse(e.contient(1.0));

        Ensemble f = c.union(d);
        assertEquals(3, f.taille());
        assertTrue(f.contient(3));
        assertFalse(f.contient(1.0));
    }
}
