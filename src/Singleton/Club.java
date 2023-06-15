package Singleton;

import Entrainement.Exercice;
import personne.intervenant.Employé;
import personne.intervenant.Joueur;
import Entrainement.EntrainementCollectif;
import Entrainement.EntrainementSolo;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;





public class Club {
    private static Club instance;
    private final ArrayList<Joueur> ListJoueurs;
    private final ArrayList<Employé> ListEmployes;

    private final ArrayList<EntrainementCollectif> ListEntColl;
    private final ArrayList<EntrainementSolo> ListEntSolo;

    private final ArrayList<Exercice> ListExercices;

    private static int numeroEmp = 1;


    private Club() {
        ListJoueurs = new ArrayList<Joueur>();
        ListEmployes = new ArrayList<Employé>();
        ListEntColl = new ArrayList<EntrainementCollectif>();
        ListEntSolo = new ArrayList<EntrainementSolo>();
        ListExercices = new ArrayList<Exercice>();
        LocalDate dateNaissance = LocalDate.of(2000, 7, 12);
        Employé e1 = new Employé("Bodson","Alexis",dateNaissance,numeroEmp,"alexis",Employé.ENTRAINEURTECH);
        e1.setMotdepasse("alexis");
        ListEmployes.add(e1);
        numeroEmp++;
        Joueur joueur1 = new Joueur("Messi", "Lionel", dateNaissance, 10 ,Joueur.Poste.ATTAQUANT, 1300000);
        ListJoueurs.add(joueur1);
    }

    public static Club getInstance() {
        if (instance == null) {
            instance = new Club();
        }
        return instance;
    }

    public void addJoueur(Joueur joueur) {
        ListJoueurs.add(joueur);
    }

    public void removeJoueur(Joueur joueur) {
        ListJoueurs.remove(joueur);
    }

    public  ArrayList<Joueur> getJoueurs() {return ListJoueurs;}
    public void addEmploye(Employé e) {
        e.setNumId(numeroEmp);
        numeroEmp++;
        ListEmployes.add(e);
    }

    public void removeEmploye(Employé e) {
        ListEmployes.remove(e);
    }

    public ArrayList<Employé> getEmployes() {
        return ListEmployes;
    }
    public void addEntrainementCollectif(EntrainementCollectif ent) {
        ListEntColl.add(ent);
    }

    public void removeEntrainementCollectif(EntrainementCollectif ent) {
        ListEntColl.remove(ent);
    }

    public ArrayList<EntrainementCollectif> getEntrainementCollectifs() {
        return ListEntColl;
    }
    public void addEntrainementSolo(EntrainementSolo ent) {
        ListEntSolo.add(ent);
    }

    public void removeEntrainementSolo(EntrainementSolo ent) {
        ListEntSolo.remove(ent);
    }

    public ArrayList<EntrainementSolo> getEntrainementSolos() {
        return ListEntSolo;
    }
    public void addExercice(Exercice ex) {
        ListExercices.add(ex);
    }
    public ArrayList<Exercice> getExercices(){return ListExercices;}
    public void readCSVFile(String filePath) {
        String csvDelimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Lecture de l'en-tête
            line = br.readLine();
            String[] headers = line.split(csvDelimiter);

            // Vérification des colonnes
            if (headers.length < 3 || !headers[0].equals("Code") || !headers[1].equals("Intitule") || !headers[2].equals("Duree")) {
                System.out.println("Le format du fichier CSV est incorrect.");
                return;
            }

            // Lecture des lignes de données
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvDelimiter);

                // Vérification du nombre de colonnes
                if (data.length >= 3) {
                    String code = data[0];
                    String intitule = data[1];
                    int duree = Integer.parseInt(data[2]);

                    Exercice ex = new Exercice(code,intitule,duree);
                    addExercice(ex);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Club club = Club.getInstance();
        //TEST DE LA LISTE JOUEUR
        LocalDate dateNaissance = LocalDate.of(2000, 7, 12);
        Joueur joueur2= new Joueur("Bodson", "Alexis", dateNaissance , 11,  Joueur.Poste.ATTAQUANT, 300000);
        Joueur joueur1 = new Joueur("Messi", "Lionel", dateNaissance, 10 ,Joueur.Poste.ATTAQUANT, 1300000);
        club.addJoueur(joueur1);
        club.addJoueur(joueur2);
        ArrayList<Joueur> list = club.getJoueurs();
        System.out.println(list);

        club.removeJoueur(joueur2);

        System.out.println(club.getJoueurs());
        System.out.println("\n\n\n");

        //TEST DE LA LISTE EMPLOYE

        Employé e2= new Employé("Bodson", "Alexis", dateNaissance, 1,"Alexis1207" ,Employé.ENTRAINEURPHYS );
        Employé e1= new Employé("Messi", "Lionel", dateNaissance, 2 ,"Messi1207",Employé.ADMINISTRATIF);
        club.addEmploye(e1);
        club.addEmploye(e2);
        ArrayList<Employé> list2 = club.getEmployes();
        System.out.println(list2);
        System.out.println("\n\n\n");


        club.removeEmploye(e1);

        System.out.println(club.getEmployes());
        System.out.println("\n\n\n");



    }
}
