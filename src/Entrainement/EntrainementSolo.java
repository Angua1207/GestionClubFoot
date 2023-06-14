package Entrainement;

import personne.intervenant.Joueur;
import personne.intervenant.Employé;

import java.time.LocalDate;


public class EntrainementSolo extends Entrainement
{
    private Joueur joueur;

    public EntrainementSolo()
    {
        super();
        this.joueur = null;
    }

    public EntrainementSolo(LocalDate date, int duree, Employé entraineur, String description, Joueur joueur)
    {
        super(date, duree, entraineur, description);
        this.joueur = joueur;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nJoueur = " + joueur;
    }

    public boolean equals(EntrainementSolo e)
    {
        if (super.equals(e) && joueur.equals(e.getJoueur())) return true;
        else return false;
    }
    public static void main(String[] args) {
        //TEST CONSTRUCTEUR DEFAUT
        EntrainementSolo e1 = new EntrainementSolo();
        System.out.println(e1);

        //TEST CONTRUCTEUR INITIALISATION
        Employé entraineur1 = new Employé("Bodson","Phil",LocalDate.of(2000,7,12),1,"Phil" ,Employé.ENTRAINEURPHYS);
        Joueur j2= new Joueur("Bodson", "Alexis", LocalDate.of(2003,7,18), 10,Joueur.Poste.ATTAQUANT, 300000);
        EntrainementSolo e2 = new EntrainementSolo(LocalDate.of(2023,4,14), 145, entraineur1, "Entrainement Musculaire", j2 );
        System.out.println(e2);

        //TEST SETTER GETTER
        Joueur j3= new Joueur("Bodson", "Alexis", LocalDate.of(2005,5,18), 4,Joueur.Poste.DEFENSEUR, 300000);
        e2.setJoueur(j3);
        e2.setDuree(112);
        System.out.println("\n\nLa duree = "+ e2.dureeEnHeuresMinutes(e2.getDuree()) + "\nLa date = "+ e2.getDate()+"\nL'entraineur = \n" + e2.getEntraineur()+"\n La déscription = "+ e2.getDescription()+ "\n Le joueur = " + e2.getJoueur());

        //TEST METHODE EQUALS
        if(e1.equals(e2))
            System.out.println("\nLes memes entrainements");
        else
            System.out.println("\nPas les memes entrainements");

        EntrainementSolo e3 = new EntrainementSolo(LocalDate.of(2023,4,14),145,entraineur1, "Entrainement Musculaire", j3);

        if(e2.equals(e3))
            System.out.println("\nLes memes entrainements");
        else
            System.out.println("\nPas les memes entrainements");


    }
}
