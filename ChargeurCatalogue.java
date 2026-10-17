import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ChargeurCatalogue {
    public static List<String> chargerTitres(Path chemin)
            throws CatalogueCorrompuException {
        try {
            return Files.readAllLines(chemin);
        } catch (IOException e) {
            throw new CatalogueCorrompuException(
                    "Erreur de lecture : " + chemin, e
            );
        }
    }
}