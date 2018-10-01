package eksempelklasser;

public enum Maned {
    JAN ("Januar"),
    FEB ("Februar"),
    MAR ("Mars"),
    APR ("April"),
    MAI ("Mai"),
    JUN ("Juni"),
    JUL ("Juli"),
    AUG ("August"),
    SEP ("September"),
    OKT ("Oktober"),
    NOV ("November"),
    DEC ("Desember");

    private final String mndNavn;

    private Maned(String maned) {
        this.mndNavn = maned;
    }

    public String toString() {
        return this.mndNavn;
    }

}
