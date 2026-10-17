import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Catalogue<T extends Document> {
    private final List<T> documents = new ArrayList<>();

    public void ajouter(T document) {
        documents.add(document);
    }

    public Optional<T> rechercherParTitre(String titre) {
        return documents.stream()
                .filter(d -> d.getTitre().equalsIgnoreCase(titre))
                .findFirst();
    }

    public List<T> getDocuments() {
        return documents;
    }
}