package Entrainement;

import personne.intervenant.*;


import java.time.LocalDate;
import java.util.ArrayList;

public class EntrainementCollectif extends Entrainement {
    private final ArrayList<Exercice> ListExercicesEnt;

    public EntrainementCollectif() {
        super();
        ListExercicesEnt = new ArrayList<>();
    }


    public EntrainementCollectif(LocalDate date, int duree, Employé entraineur, String description,ArrayList<Exercice> exercices) {
        super(date, duree, entraineur, description);
        ListExercicesEnt = new ArrayList<>(exercices);
    }
    public void addExerciceEnt(Exercice ex) {
        ListExercicesEnt.add(ex);
    }

    public ArrayList<Exercice> getExerciceEnt(){return ListExercicesEnt;}


    public boolean equals(EntrainementCollectif e) {
        return super.equals(e);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
    /*public static void main(String[] args) {
        //TEST CONSTRUCTEUR DEFAUT
        EntrainementCollectif e1 = new EntrainementCollectif();
        System.out.println(e1);

        //TEST CONTRUCTEUR INITIALISATION
        Employé entraineur1 = new Employé("Bodson","Phil",LocalDate.of(2000,7,12),1,"Phil" ,Employé.ENTRAINEURPHYS);
        EntrainementCollectif e2 = new EntrainementCollectif(LocalDate.of(2023,4,14), 145, entraineur1, "Entrainement Musculaire" );
        System.out.println(e2);

        //TEST SETTER GETTER
        Employé entraineur2 = new Employé("Bodson","Alexis",LocalDate.of(2000,7,12),1, "Alexis1207",Employé.ENTRAINEURPHYS);
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

        EntrainementCollectif e3 = new EntrainementCollectif(LocalDate.of(2024,5,5),120,entraineur2, "Entrainement Musculaire");

        if(e2.equals(e3))
            System.out.println("\nLes memes entrainements");
        else
            System.out.println("\nPas les memes entrainements");
    }
}*/
