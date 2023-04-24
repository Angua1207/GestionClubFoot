public class Main {
    public static void main(String[] args) {
        // TEST DE LE CLASSE PERSONNE//
        /*
        LocalDate dateNaissance = LocalDate.of(2000, 7, 12);
        Personne p = new Personne("Bodson", "Alexis", dateNaissance );
        System.out.println(p);
        dateNaissance = LocalDate.of(2000, 7, 18);
        Personne p2 = new Personne("Arianna", "Grande", dateNaissance);
        if(p2.equals(p))
            System.out.println(p2);
        else
            System.out.println("Pas les mêmes personnes\n");
        Personne p3 = p2;
        System.out.println(p3);
        p2.setNom("MAMAMA");
        System.out.println(p3);*/

        //TEST DE LA CLASSE JOUEUR

        /*Joueur j1 = new Joueur();
        System.out.println("Salaire = " + j1.getSalaire());
        System.out.println("\n");
        LocalDate dateNaissance = LocalDate.of(2000, 7, 12);
        Joueur j2= new Joueur("Bodson", "Alexis", dateNaissance , Joueur.Poste.ATTAQUANT, 300000);
        System.out.println(j2);
        Joueur j3= new Joueur("Bodson", "Alexis", dateNaissance , Joueur.Poste.ATTAQUANT, 800000);
        if(j2.equals(j3))
            System.out.println("\nCe sont les memes joueurs");
        else
        {
            System.out.println("\nPas les memes joueurs\n");
            System.out.println(j3);
        }*/

        //TEST CLASSE EMPLOYE (STAFF)
        /*LocalDate dateNaissance = LocalDate.of(2000, 7, 12);

        Employé e1 = new Employé("Bodson","Alexis",dateNaissance,1,"alexis", Employé.ENTRAINEURPHYS);
        System.out.println(e1);
        System.out.println("\n");
        Employé e2 = new Employé();
        System.out.println(e2);
        Employé e3 = new Employé("Bodson","Phil",dateNaissance,1,"alexis", Employé.ENTRAINEURPHYS);
        if(e1.equals(e3))
            System.out.println("\nLes memes employés");
        else
            System.out.println("\nPas les memes \n\nLa preuve :\n\n "+ e3);

        Employé e4 = e1;
        if(e1.equals(e4))
            System.out.println("\nLes memes employés");
        else
            System.out.println("\nPas les memes \n\nLa preuve :\n\n "+ e3);
        e4.setFonction(Employé.ENTRAINEURTECH);
        System.out.println(e4 + "\n");
        System.out.println(e1);*/






    }
}