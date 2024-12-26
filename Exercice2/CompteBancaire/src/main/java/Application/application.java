package Application;

import entities.CompteBancaire;
import entities.CompteCourant;
import entities.CompteEpargne;
import exceptions.CompteInexistantException;
import exceptions.FondsInsuffisantsException;

import java.util.ArrayList;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<CompteBancaire>();
        Scanner clavier = new Scanner(System.in);
        int opc = 0;
        do{
            System.out.println("1. Ajouter un compte");
            System.out.println("2. Supprimer un compte");
            System.out.println("3. Déposer de l'argent");
            System.out.println("4. Retirer de l'argent");
            System.out.println("5. Afficher les soldes");
            System.out.println("6. Transférer de l'argent");
            System.out.println("7. Appliquer les intérêts ");
            System.out.println("8. Quitter");
            System.out.println("\t");
            System.out.println("Choisisser une option");
            opc = clavier.nextInt();

            switch(opc){
                case 1:
                    System.out.println("Type de compte (1: éparge, 2: courant)");
                    int type= clavier.nextInt();

                    System.out.println("Saisissez le numéro de compte)");
                    int numero= clavier.nextInt();
                    System.out.println("Saisissez le solde du compte)");
                    double sold= clavier.nextDouble();
                    System.out.println("Saisissez le nom du titulaire)");
                    String nomtitulaire= clavier.next();

                    if(type == 1){
                        System.out.println("Saisissez le taux d'interêt)");
                        double taux= clavier.nextDouble();

                        comptes.add(new CompteEpargne(numero,sold,nomtitulaire,taux));
                    }else if(type == 2){
                        System.out.println("Saisissez le découvert)");
                        double decouvert= clavier.nextDouble();
                        comptes.add(new CompteCourant(numero,sold,nomtitulaire,decouvert));
                    }
                    break;
                case 2:
                    System.out.println("Saisissez le numéro de compte à supprimer)");
                    int numeroCompte= clavier.nextInt();
                    comptes.removeIf(compte->compte.getNumeroCompte()==numeroCompte);
                    break;
                case 3:
                    System.out.println("Saisissez le montant à déposer)");
                    double montant= clavier.nextDouble();
                    System.out.println("Saisissez le numero du compe)");
                    int numCompte= clavier.nextInt();

                    comptes.forEach(compte -> {
                        if (compte.getNumeroCompte() == numCompte) {
                            compte.depotArgent(montant);
                           return;
                        }
                    });
                    break;
                case 4:
                    System.out.println("Saisissez le montant à retirer)");
                    double mont= clavier.nextDouble();
                    System.out.println("Saisissez le numero du compe)");
                    int CompteId= clavier.nextInt();

                    for(CompteBancaire compte : comptes){
                        if(compte.getNumeroCompte() == CompteId){
                            try {
                                compte.retraitArgent(mont);
                                break;
                            } catch (FondsInsuffisantsException e) {
                              System.out.println("Erreur: "  + e.getMessage());
                            }
                        }
                    }

                    break;
                case 5:
                    comptes.forEach(compte -> {
                        compte.afficheSolde();
                    });
                    break;
                case 6:
                    System.out.println("Saisissez le montant à transférer)");
                    double mt= clavier.nextDouble();

                    System.out.println("Saisissez le numero du compte éméteur)");
                    int CpIdEmeteur = clavier.nextInt();

                    System.out.println("Saisissez le numero du compte bénéficiaire)");
                    int CpIdestinateur = clavier.nextInt();

                    CompteBancaire  cptEmeteur=null;
                    CompteBancaire  cptDestination=null;

                    for(CompteBancaire compte : comptes){
                         if(compte.getNumeroCompte()==CpIdEmeteur){
                             cptEmeteur=compte;
                         }else if(compte.getNumeroCompte()==CpIdestinateur){
                            cptDestination=compte;
                        }
                        try {
                            if (cptEmeteur != null && cptDestination != null){
                                cptEmeteur.transferCredit(cptDestination,mt);
                            }else{
                                throw new CompteInexistantException("l'un des comptes est innexistant !!!! ");
                            }
                        } catch (FondsInsuffisantsException | CompteInexistantException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Saisissez le numero du compte )");
                    int CpIdEpargne = clavier.nextInt();
                    System.out.println("Saisissez le numero du compte )");
                    double tx = clavier.nextDouble();

                    for(CompteBancaire compte : comptes){
                        if(compte.getNumeroCompte()==CpIdEpargne){
                            if (compte instanceof CompteEpargne){
                                 ((CompteEpargne) compte).appliquerTauxInteret(tx);
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("Terminer !!!!");
                    clavier.close();
                    return;
                default:
                    System.out.println("Choix incorrecte");
            }

        }while(opc <9);




    }
}
