package lst.fsts.javafxtps;

public class Etudiant {
    private String nom, prenom, email, cne;
    private int id;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, String email, String cne, int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cne = cne;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Etudiant setId(int id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Etudiant setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public Etudiant setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Etudiant setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCne() {
        return cne;
    }

    public Etudiant setCne(String cne) {
        this.cne = cne;
        return this;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", cne='" + cne + '\'' +
                ", id=" + id +
                '}';
    }
}
