import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Cette classe modélise un ensemble, c'est-à-dire une collection d'objets distincts. Les objets contenus sont garantis
 * non-<code>null</code>. Les instances de cette classe sont immuables.
 */
public class Ensemble {

    /**
     * Construit un nouvel ensemble vide.
     */
    public Ensemble() {
        throw new UnsupportedOperationException("méthode non implémentée");
    }

    /**
     * Construit un nouvel ensemble contenant tous les éléments distinct d'une collection.
     *
     * @param objets la collection d'objet contenus dans l'ensemble
     * @throws NullPointerException si la collection contient un élément <code>null</code>
     */
    public Ensemble(Collection<Object> objets) throws NullPointerException {
        throw new UnsupportedOperationException("méthode non implémentée");
    }

    /**
     * Retourne le nombre d'éléments dans l'ensemble (sa cardinalité).
     *
     * @return le nombre d'éléments distincts contenus dans l'ensemble
     */
    public int taille() {
        throw new UnsupportedOperationException("méthode non implémentée");
    }

    /**
     * Retourne <code>true</code> si l'ensemble contient l'élément spécifié.
     *
     * @param o l'élément dont la présence est testée
     * @return <code>true</code> si et seulement si l'ensemble contient un élément <code>x</code> tel que <code>o.equals(x)</code>.
     */
    public boolean contient(Object o) {
        throw new UnsupportedOperationException("méthode non implémentée");
    }

    /**
     * Retourne un objet contenu dans l'ensemble. Le choix de l'objet est arbitraire, mais différents appels à cette
     * méthode pour un ensemble donné retournent toujours le même élément.
     *
     * @return un objet contenu dans l'ensemble
     * @throws NoSuchElementException si l'ensemble ne contient aucun élément
     */
    public Object element() throws NoSuchElementException {
        throw new UnsupportedOperationException("méthode non implémentée");
    }

    /**
     * Retourne l'union de l'ensemble et de l'ensemble spécifié.
     *
     * @param e l'ensemble avec lequel calculer l'union
     * @return un nouvel ensemble contenant tous les éléments distincts contenus dans cet ensemble ou dans <code>e</code>
     */
    public Ensemble union(Ensemble e) {
        throw new UnsupportedOperationException("méthode non implémentée");
    }

}
