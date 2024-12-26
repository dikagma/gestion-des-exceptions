package entities;

import exceptions.CompteInexistantException;
import exceptions.FondsInsuffisantsException;

public class CompteBancaire {
    int numeroCompte;
    double solde;
    String nomDuTitulaire;

    public CompteBancaire() {
    }

    public CompteBancaire(int numeroCompte, double solde, String nomDuTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomDuTitulaire = nomDuTitulaire;
    }

    public int getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(int numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public String getNomDuTitulaire() {
        return nomDuTitulaire;
    }

    public void setNomDuTitulaire(String nomDuTitulaire) {
        this.nomDuTitulaire = nomDuTitulaire;
    }

    public void depotArgent(double montant){
        if(montant > 0){
         solde += montant;
        }
    }

    public void retraitArgent(double montant) throws FondsInsuffisantsException {
        if(solde-montant < 0 ) throw new FondsInsuffisantsException("Solde insuffisant pour effectuer cette opération");
        solde -= montant;
    }

    public void afficheSolde(){
      System.out.println("Solde du compte N° : " + this.getNumeroCompte() + " est : " + this.getSolde());
    }

    public void transferCredit(CompteBancaire compteBancaireDestination , double montant) throws FondsInsuffisantsException, CompteInexistantException {

        if(compteBancaireDestination == null) throw  new CompteInexistantException("Compte de destination inexistant !!! ");
        this.retraitArgent(montant);
        compteBancaireDestination.depotArgent(montant);

    }
}
