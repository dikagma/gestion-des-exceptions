package entities;

import exceptions.FondsInsuffisantsException;

public class CompteCourant extends CompteBancaire {
    double decouvert;

    public CompteCourant(int numeroCompte, double solde, String nomDuTitulaire, double decouvert) {
        super(numeroCompte, solde, nomDuTitulaire);
        this.decouvert = decouvert;
    }

    @Override
    public void retraitArgent(double montant) throws FondsInsuffisantsException {
       if(solde + decouvert < montant) throw new FondsInsuffisantsException("Vous dépassez le découvert autorisé !!!!!! ");
        solde -= montant;
    }
}
