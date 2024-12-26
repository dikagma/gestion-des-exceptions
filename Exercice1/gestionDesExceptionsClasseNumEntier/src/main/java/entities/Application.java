package entities;

import exceptions.NombreNegatifException;

public class Application {
    public static void main(String[] args) {
        try {
            EntierNaturel entierNaturel = new EntierNaturel(5);
            entierNaturel.setVal(1);
            System.out.println(entierNaturel.getVal());
            entierNaturel.decrementer();
            entierNaturel.decrementer();

            System.out.println(entierNaturel.getVal());
        } catch (NombreNegatifException e) {
            System.out.println("Exception capturée : " + e.getMessage());
            System.out.println("Valeur erronée : " + e.getErrorValue());
        }

    }
}
