package personne;
import java.time.LocalDate;
public class Personne
{
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;


    public Personne()
    {
        nom = "Truc";
        prenom = "Machin";
        dateNaissance = LocalDate.of(1789,1,1);
    }

    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public boolean equals(Personne p)
    {
        if (nom.equals(p.nom) && prenom.equals(p.prenom)
                && dateNaissance.equals(p.dateNaissance)) return true;
        else return false;
    }

    public String toString(){
        String temp;
        temp = "Nom : " +getNom() + "\n" + "Prenom : "+ getPrenom()+ "\n" + "Date Naissance : " + getDateNaissance();
        return temp;
    }
}