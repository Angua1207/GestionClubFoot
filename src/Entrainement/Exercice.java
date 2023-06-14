package Entrainement;

import java.lang.reflect.Executable;
import java.util.Objects;

public class Exercice {
    private String Code;
    private String Intitule;
    private int duree;

    public Exercice(String code, String intitule, int duree) {
        Code = code;
        Intitule = intitule;
        this.duree = duree;
    }

    public Exercice() {
        Code = "OPPO";
        Intitule = "MaMa";
        this.duree = 15;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getIntitule() {
        return Intitule;
    }

    public void setIntitule(String intitule) {
        Intitule = intitule;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "\nExercice :" +
                "\nCode = " + Code +
                "\nIntitule = " + Intitule +
                "\nduree=" + duree + "\n";
    }
    public boolean equals(Exercice e){
        if(getCode().equals(e.getCode())|| getIntitule().equals(e.getIntitule())) return true;
        else return false;
    }
}

