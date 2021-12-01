/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Plongee {
    
    protected Set<Plongeur> lesParticipants = new HashSet<>();
    private Set<Licence> licencesParticipants = new HashSet<>();
    
    public Site lieu;
    
    public Moniteur chefDePalanquee;
    
    public LocalDate date;
    
    public int profondeur;
    
    public int duree;
    
    public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
        this.lieu = lieu;
        this.chefDePalanquee = chefDePalanquee;
        this.date = date;
        this.profondeur = profondeur;
        this.duree = duree;
    }

    public void ajouteParticipant(Plongeur participant) {
        if(!lesParticipants.contains(participant)) lesParticipants.add(participant);
    }

    public LocalDate getDate() {
        return date;
    }

    /**
     * Détermine si la plongée est conforme. Une plongée est conforme si tous
     * les plongeurs de la palanquée ont une licence valide à la date de la
     * plongée
     *
     * @return vrai si la plongée est conforme
     */
    public boolean estConforme() {
        boolean res = true;
        
        //On vérifie pour l'ensemble des participants
        for(Plongeur p : lesParticipants){
            //Si la dernière licence qu'ils ont (la plus récente) est valide à la date de la plongée
            if(!p.derniereLicence().estValide(this.getDate())){
            res = false;
        }
        }
        return res;
    }

}
