package exceptions;

public class NombreNegatifException extends Exception {
    int errorValue;
    public NombreNegatifException(String s, int errorV) {
        super(s);
        errorValue = errorV;
    }
    public int getErrorValue() {
        return  errorValue;
    }
}
