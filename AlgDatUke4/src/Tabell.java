import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Tabell {

    private Tabell() {}

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        fratilKontroll(a.length,fra,til);
        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if(a == null) {
            throw new NullPointerException("Arrayen er null");
        }

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }


    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }

    public static void skriv(int[] a, int fra, int til) {
        for(int i = fra; i < til; ++i) {
            if(i == til - 1) {
                System.out.print(a[i]);
            }
            else {
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void skriv(int[] a){
        skriv(a, 0, a.length);
    }

    public static int min(int[] a, int fra, int til) {

        int minimum = a[fra];
        int m = fra;

        for(int i = fra + 1; i<til; ++i) {
            if(a[i] < minimum) {
                m = i;
                minimum = a[m];
            }
        }
        return m;
    }

    public static void bytt(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void skrivln(int[] a, int fra, int til) {
        fratilKontroll(a.length,fra,til);
        for(int i = fra; i < til; ++i) {
            System.out.println(a[i]);
        }
    }

    public static void skrivln(int[] a){
        skrivln(a, 0, a.length);
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }

    public static void snu(int[] a, int v, int h) {
        vhKontroll(a.length, v, h);
        int slutt = h;
        for(int i = v; i < slutt; ++i) {
            int temp = a[i];
            a[i] = a[slutt];
            a[slutt] = temp;
            slutt--;
        }
    }

    public static void snuHelTabell(int[] a) {
        snu(a, 0, a.length - 1);
    }

    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;     // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a,1,n);                    // leter i a[1:n>
        }
        else if (m == n-1)                     // den største ligger bakerst
        {
            nm = maks(a,0,n-1);                  // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a,0,m);                // leter i a[0:m>
            int mh = maks(a,m+1,n);              // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    }

    public static int[] nestMaksv2(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        if(m != 0) {
            bytt(a, m, 0);
            m = 0;
        }

        int nm = maks(a,1,n-1);     // nm skal inneholde posisjonen til nest største verdi
        if(nm != 1) {
            bytt(a, nm, 1);
            nm = 1;
        }


        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    }

    public static int[] sortertArray(int[] a) {

        int n = a.length;

        for(int i = 0; i < n; i++) {
            int m = maks(a, i, n);
            if(m != i) {
                bytt(a, m, i);
            }
        }

        return a;
    }

    public static int[] sortering(int[] a) {
        int n = a.length;

        for(int i = n; i > 1; i--) {
            int m = maks(a, 0, i);
            if(m != i) {
                bytt(a,m,i-1);
            }
        }
        return a;
    }
    //1.2.13 a)
    public static int[] nestMaksv3(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst
    } // nestMaks

    public static void kopier(int[] a, int i, int[] b, int j, int ant) {

        for(int n = i + ant; i < n;) {
            b[j++] = a[i++];
        }
    }

    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }

    public static int maks(char[] a) {

        int m = 0;
        char maksverdi = a[0];

        for(int i = 1; i < a.length; i++) {
            if(a[i] > maksverdi) {
                maksverdi = a[i];
                m = i;
            }
        }
        return m;
    }


    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    }

    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    static void skriv(Object[] a, int fra, int til) {
        for(int i = fra; i < til && i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void skriv(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void skrivln(Object[] a, int fra, int til) {
        for(int i = fra; i < til && i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }

    static void skrivln(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }

    static void bytt(Object[] a, int i, int j) {
        Object tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }
}