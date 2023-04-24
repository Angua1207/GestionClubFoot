import personne.Intervenant.Employé;
import personne.Intervenant.Joueur;
import Entrainement.EntrainementCollectif;
import Entrainement.EntrainementSolo;
import java.util.ArrayList;
import java.time.LocalDate;





public class Club {
    private static Club instance;
    private final ArrayList<Joueur> ListJoueurs;
    private final ArrayList<Employé> ListEmployes;

    private final ArrayList<EntrainementCollectif> ListEntColl;
    private final ArrayList<EntrainementSolo> ListEntSolo;


    private Club() {
        ListJoueurs = new ArrayList<Joueur>();
        ListEmployes = new ArrayList<Employé>();
        ListEntColl = new ArrayList<EntrainementCollectif>();
        ListEntSolo = new ArrayList<EntrainementSolo>();

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

    public ArrayList<Joueur> getJoueurs() {
        return ListJoueurs;
    }
    public void addEmploye(Employé e) {
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

        Employé e2= new Employé("Bodson", "Alexis", dateNaissance, 1, "Alexis1207", Employé.ENTRAINEURPHYS );
        Employé e1= new Employé("Messi", "Lionel", dateNaissance, 10 ,"Messi1207",Employé.ADMINISTRATIF);
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
