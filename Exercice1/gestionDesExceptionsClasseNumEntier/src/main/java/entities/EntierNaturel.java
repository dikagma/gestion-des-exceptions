package entities;

import exceptions.NombreNegatifException;

public class EntierNaturel {
    int val;

    public EntierNaturel(int val) throws NombreNegatifException {
        if (val<0) throw new NombreNegatifException("Le nombre ne doit pas être négatif",val);
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) throws NombreNegatifException {
        if(val<0) throw new NombreNegatifException("Le nombre ne doit pas être négatif", val);
        this.val = val;
    }

    public int decrementer() throws NombreNegatifException {
        if(val-1< 0) throw new NombreNegatifException("Le nombre ne doit pas être négatif",val-1);
        return --val;
    }

}
