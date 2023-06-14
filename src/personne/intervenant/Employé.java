package personne.intervenant;

import java.time.LocalDate;

public class Employé extends personne.intervenant.Intervenant
{
    private String Login;
    private String Motdepasse;
    private String fonction;
    public static  final String ADMINISTRATIF  = "Administratif" ;

    public static  final String ENTRAINEURTECH = "Entraineur technique";

    public static  final String ENTRAINEURPHYS = "Entraineur physique";





    public Employé() {
        super();
        setLogin("BLABLA");
        setMotdepasse("");
        setFonction("Entraineur technique");


    }

    public Employé(String nom, String prenom, LocalDate dateNaissance, int numId,String login, String fonction) {
        super(nom, prenom, dateNaissance, numId);
        this.Login = login;
        this.Motdepasse = "";
        this.fonction = fonction;
    }


    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getMotdepasse() {
        return Motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        Motdepasse = motdepasse;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLogin =  " + Login +
                "\nFonction = " + fonction + "\n\n";
    }
    public boolean equals(Employé e)
    {
        if (super.equals(e) && Login.equals(e.getLogin())) return true;
        else return false;
    }
}
