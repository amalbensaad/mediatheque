import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpruntManagerTest {

    @Test
    void testDocumentIntrouvable() {
        Catalogue<Document> catalogue = new Catalogue<>();
        EmpruntManager manager = new EmpruntManager(catalogue);

        assertThrows(
            DocumentIntrouvableException.class,
            () -> manager.emprunter("Livre inconnu")
        );
    }

    @Test
    void testDoubleEmprunt() throws MediathequeException {
        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(
            new Livre("Clean Code", 2008, "Robert Martin", 464)
        );

        EmpruntManager manager = new EmpruntManager(catalogue);

        manager.emprunter("Clean Code");

        assertThrows(
            DocumentIndisponibleException.class,
            () -> manager.emprunter("Clean Code")
        );
    }

    @Test
    void testRevueNonEmpruntable() {
        Catalogue<Document> catalogue = new Catalogue<>();

        catalogue.ajouter(new Revue("Science", 2026, 412));

        EmpruntManager manager = new EmpruntManager(catalogue);

        assertThrows(
            DocumentIndisponibleException.class,
            () -> manager.emprunter("Science")
        );
    }
}