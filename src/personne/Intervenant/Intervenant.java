package personne.Intervenant;

import java.time.LocalDate;

public abstract class Intervenant extends personne.Personne
{
    protected int NumId;

    public Intervenant() {
        super();
        NumId = 696969;
    }

    public Intervenant(String nom, String prenom, LocalDate dateNaissance, int numId) {
        super(nom, prenom, dateNaissance);
        NumId = numId;
    }

    public int getNumId() {
        return NumId;
    }

    public void setNumId(int numId) {
        NumId = numId;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNumero = " + NumId;
    }
    public boolean equals(Intervenant s)
    {
        if (super.equals(s) && NumId==s.NumId) return true;
        else return false;
    }
}
