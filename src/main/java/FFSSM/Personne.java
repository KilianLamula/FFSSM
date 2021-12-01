/**
 * @(#) Personne.java
 */
package FFSSM;

import java.time.LocalDate;

public class Personne {

    protected String numeroINSEE;

    protected String nom;

    protected String prenom;

    protected String adresse;

    protected String telephone;

    protected LocalDate naissance;

    public Personne(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance) {
        setNumeroINSEE(numeroINSEE); // Le mutateur fait le contrôle non null
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.naissance = naissance;
    }

    public String getNumeroINSEE() {
        return numeroINSEE;
    }

    public void setNumeroINSEE(String numeroINSEE) {
        // Vérifier la cardinalité implicite [1]
        if (null == numeroINSEE) {
            throw new IllegalArgumentException("numeroINSEE is null");
        }
        this.numeroINSEE = numeroINSEE;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }
}
