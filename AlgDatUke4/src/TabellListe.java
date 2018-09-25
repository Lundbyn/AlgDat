import java.util.*;

public class TabellListe<T> implements Liste<T> {

    private T[] a;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellListe(int size) {
        a = (T[]) new Object[size];
        antall = 0;
    }

    public TabellListe() {
        this(10);
    }

    public TabellListe(T[] b)                    // en T-tabell som parameter
    {
        this(b.length);                            // kaller den andre konstruktøren

        for (T verdi : b) {
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }


    public boolean leggInn(T verdi)  // inn bakerst
    {
        Objects.requireNonNull(verdi, "null er ulovlig!");

        if (antall == a.length)  // En full tabell utvides med 50%
        {
            a = Arrays.copyOf(a, (3 * antall) / 2 + 1);
        }

        a[antall++] = verdi;    // setter inn ny verdi
        return true;            // vellykket innlegging
    }

    public void leggInn(int indeks, T verdi) {
        Objects.requireNonNull(verdi, "null er ulovlig!");
        indeksKontroll(indeks, true);  // true: indeks = antall er lovlig

        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a, (3 * antall) / 2 + 1);

        // rydder plass til den nye verdien
        System.arraycopy(a, indeks, a, indeks + 1, antall - indeks);

        a[indeks] = verdi;     // setter inn ny verdi
        antall++;              // vellykket innlegging
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;
    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }

    @Override
    public int indeksTil(T verdi) {
        for (int i = 0; i < antall; i++) {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        return null;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks, false);  // false: indeks = antall er ulovlig
        T verdi = a[indeks];

        antall--; // sletter ved å flytte verdier mot venstre
        System.arraycopy(a, indeks + 1, a, indeks, antall - indeks);
        a[antall] = null;   // tilrettelegger for "søppeltømming"

        return verdi;
    }

    @Override
    public boolean fjern(T verdi) {

        for (int i = 0; i < antall; i++) {
            if (hent(i) == verdi) {
                fjern(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int antall() {
        return antall;          // returnerer antallet
    }

    @Override
    public boolean tom() {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    @Override
    public void nullstill() {
        for (int i = antall - 1; i >= 0; i--) {
            fjern(i);
        }
    }

    @Override
    public String toString() {

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < this.antall; i++) {
            stringJoiner.add("" + hent(i));
        }
        return "" + stringJoiner;
    }

    public void fjernHvis() {

    }


    private class TabellListeIterator implements Iterator<T> {
        private int denne = 0;       // instansvariabel

        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        private boolean fjernOK = false;   // ny instansvariabel i TabellListeIterator

        public T next()                    // ny versjon
        {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

            T denneVerdi = a[denne];   // henter aktuell verdi
            denne++;                   // flytter indeksen
            fjernOK = true;            // nå kan remove() kalles

            return denneVerdi;         // returnerer verdien
        }

        public void remove()         // ny versjon
        {
            if (!fjernOK) throw
                    new IllegalStateException("Ulovlig tilstand!");

            fjernOK = false;           // remove() kan ikke kalles på nytt

            // verdien i denne - 1 skal fjernes da den ble returnert i siste kall
            // på next(), verdiene fra og med denne flyttes derfor en mot venstre
            antall--;           // en verdi vil bli fjernet
            denne--;            // denne må flyttes til venstre

            System.arraycopy(a, denne + 1, a, denne, antall - denne);  // tetter igjen
            a[antall] = null;   // verdien som lå lengst til høyre nulles
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TabellListeIterator();
    }

    private boolean fjernOK = false;   // ny instansvariabel i TabellListeIterator


}
