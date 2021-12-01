package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;

public class Plongeur extends Personne {

    ArrayList<Licence> lesLicences = new ArrayList<>();
    private int niveau;
    private GroupeSanguin grp;

    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin grp) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.grp = grp;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void ajouterLicence(String numero, LocalDate delivrance, Club club) {
        lesLicences.add(new Licence(this, numero, delivrance, club));
    }

    public Licence derniereLicence() {
        return lesLicences.get(lesLicences.size() - 1);
    }

    public ArrayList<Licence> getLesLicences() {
        return lesLicences;
    }
}
