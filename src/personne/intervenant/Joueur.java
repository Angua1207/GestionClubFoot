package personne.intervenant;

import java.time.LocalDate;
public class Joueur extends personne.intervenant.Intervenant
{
    public enum Poste {
        GARDIEN,
        DEFENSEUR,
        MILIEU,
        ATTAQUANT
    }

    private Poste poste;
    private float  salaire;

    public Joueur(){
        super();
        poste = Poste.DEFENSEUR;
        salaire = 15000;
    }
    public Joueur(String nom, String prenom, LocalDate dateNaissance,int Num, Poste poste, float salaire) {
        super(nom, prenom, dateNaissance,Num);
        this.poste = poste;
        this.salaire = salaire;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        salaire = salaire;
    }

    public boolean equals(Joueur j)
    {
        if (super.equals(j) && poste.equals(j.poste) &&
            salaire == (j.salaire)) return true;
        else return false;
    }
    @Override
    public String toString() {
        return super.toString() +
                "\nposte = " + poste +
                "\nSalaire = " + salaire +
                "€\n";
    }
}
