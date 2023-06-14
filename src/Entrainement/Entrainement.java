package Entrainement;
import personne.intervenant.Employé;

import java.time.LocalDate;
import java.util.ArrayList;

public class Entrainement
{
    private LocalDate date;
    private int duree; // en minutes
    private Employé entraineur;
    private String description;

    ArrayList<Exercice> exercices;


    public Entrainement()
    {
        this.date= LocalDate.of(2023,4,13);
        this.duree= 90;
        this.entraineur=null;
        this.description = "Pas de déscription";

    }

    public Entrainement(LocalDate date, int duree, Employé entraineur, String description)
    {
        this.date = date;
        this.duree = duree;
        this.entraineur = entraineur;
        this.description = description;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Employé getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Employé entraineur) {
        this.entraineur = entraineur;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  "\nDate de l'entrainement = " + date +
                "\nDuree = " + dureeEnHeuresMinutes(duree) +
                "\nEntraineur = \n" + entraineur +
                "\nDescription = " + description + "\n";
    }
    public static String dureeEnHeuresMinutes(int dureeEnMinutes)
    {
        int heures = dureeEnMinutes / 60; // division entière pour récupérer le nombre d'heures
        int minutes = dureeEnMinutes % 60; // modulo pour récupérer le nombre de minutes restantes
        return heures + "h" + String.format("%02d", minutes); // formatage de la chaîne de sortie avec des zéros pour les minutes
    }

    public boolean equals(Entrainement e){
        if (date.equals(e.getDate()) && duree==e.getDuree() && entraineur.equals(e.getEntraineur())) return true;
        else return false;
    }

    public static void main(String[] args) {
        //TEST CONSTRUCTEUR DEFAUT
        Entrainement e1 = new Entrainement();
        System.out.println(e1);

        //TEST CONTRUCTEUR INITIALISATION
        Employé entraineur1 = new Employé("Bodson","Phil",LocalDate.of(2000,7,12),1,"¨Phi", Employé.ENTRAINEURPHYS);
        Entrainement e2 = new Entrainement(LocalDate.of(2023,4,14), 145, entraineur1, "Entrainement Musculaire" );
        System.out.println(e2);

        //TEST SETTER GETTER
        Employé entraineur2 = new Employé("Bodson","Alexis",LocalDate.of(2000,7,12),1,"alexis1207" ,Employé.ENTRAINEURPHYS);
        e2.setDate(LocalDate.of(2024,5,5));
        e2.setDuree(120);
        e2.setEntraineur(entraineur2);
        e2.setDescription("Entrainement Physique");
        System.out.println("La duree = "+ e2.getDuree() + "\nLa date = "+ e2.getDate()+"\nL'entraineur = \n" + e2.getEntraineur()+"\n La déscription = "+ e2.getDescription());

        //TEST METHODE EQUALS
        if(e1.equals(e2))
            System.out.println("\nLes memes entrainements");
        else
            System.out.println("\nPas les memes entrainements");

        Entrainement e3 = new Entrainement(LocalDate.of(2024,5,5),120,entraineur2, "Entrainement Musculaire");

        if(e2.equals(e3))
            System.out.println("\nLes memes entrainements");
        else
            System.out.println("\nPas les memes entrainements");
    }
}


