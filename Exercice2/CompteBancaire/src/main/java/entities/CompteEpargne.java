package entities;

public class CompteEpargne extends CompteBancaire{
    double tauxInteret;


    public CompteEpargne(int numeroCompte, double solde, String nomDuTitulaire, double tauxInteret) {
        super(numeroCompte, solde, nomDuTitulaire);
        this.tauxInteret = tauxInteret;
    }

    public void appliquerTauxInteret(double tauxInteret) {
        solde += solde+ tauxInteret;
    }


}
