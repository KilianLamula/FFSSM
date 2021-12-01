/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ? Une licence est
     * valide pendant un an à compter de sa date de délivrance
     *
     * @param d la date à tester
     * @return vrai si valide à la date d
     *
     */
    public boolean estValide(LocalDate d) {
        boolean res = true;

        //On récupère la date de délivrance et on lui ajoute un an
        LocalDate dateVerif = this.getDelivrance().plusYears(1);

        //Si la dateVerif est dépassée par la date indiquée alors la licence n'est plus valise : res=false
        if (d.isAfter(dateVerif)) {
            res = false;
        }

        return res;
    }

}
