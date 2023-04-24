package personne.Intervenant;

import java.time.LocalDate;

public class Employé extends personne.Intervenant.Intervenant
{
    private String login;
    private String motdepasse;
    private String fonction;
    public static  final String ADMINISTRATIF  = "Administratif" ;

    public static  final String ENTRAINEURTECH = "Entraineur technique";

    public static  final String ENTRAINEURPHYS = "Entraineur physique";

    //public static  final String MEDECIN= "Medecin";




    public Employé() {
        super();
        setLogin("pfpf");
        motdepasse = null;
        setFonction("Medecin");


    }

    public Employé(String nom, String prenom, LocalDate dateNaissance, int numId, String login,String fonction) {
        super(nom, prenom, dateNaissance, numId);
        this.login = login;
        this.motdepasse = null;
        this.fonction = fonction;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\nLogin = " + login +
                "\nMotdepasse = " + motdepasse +
                "\nFonction = " + fonction + "\n\n";
    }
    public boolean equals(Employé e)
    {
        if (super.equals(e) && login.equals(e.login)) return true;
        else return false;
    }
}
