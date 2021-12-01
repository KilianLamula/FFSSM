/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Moniteur extends Plongeur {

    List<Embauche> lesEmplois = new ArrayList<>();

    public int numeroDiplome;

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau, GroupeSanguin grp, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, grp);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() throws Exception {
        //On vérifie si le moniteur n'a pas d'emploi
        if (this.emplois().isEmpty()) throw new Exception("Le moniteur n'a pas d'employeur");
        //On vérifie si la dernière embauche est terminée
        if(emplois().get(lesEmplois.size()-1).estTerminee()) throw new Exception("La dernière embauche est terminée");
        //Sinon on retourne l'employeur (Optional car il peut être éventuellement null)
        return Optional.ofNullable(lesEmplois.get(lesEmplois.size()-1).getEmployeur());
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        lesEmplois.add(new Embauche(debutNouvelle, this, employeur));
    }

    public List<Embauche> emplois() {
        return lesEmplois;
    }

}
