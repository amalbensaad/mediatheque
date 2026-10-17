public abstract class Document {
    protected String titre;
    protected int annee;

    public Document(String titre, int annee) {
        this.titre = titre;
        this.annee = annee;
    }

    public String getTitre() {
        return titre;
    }

    public int getAnnee() {
        return annee;
    }

    public abstract String descriptionCourte();
}