import eksempelklasser.Komparator;

import java.util.Arrays;
import java.util.Comparator;
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


    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks

            // sammenligner og forskyver:
            for (; j >= 0 && c.compare(verdi,a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }

    public static <T> int maks(T[] a, Comparator<? super T> c) {
        int maks = 0;
        T maksVerdi = a[0];
        for(int i = 1; i < a.length; i++) {
            if(c.compare(a[i], maksVerdi) > 0) {
                maks = i;
                maksVerdi = a[i];
            }
        }
        return maks;
    }


    //Comparator metoder

    public static <T> void bytt(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c) {

        int min = fra;
        T minVerdi = a[fra];

        for(int i = fra + 1; i < til; i++) {
            if(c.compare(a[i], minVerdi) < 0) {
                minVerdi = a[i];
                min = i;
            }
        }
        return min;
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));
    }

    public static <T> int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m; // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static <T> void kvikksortering0(T[] a, int v, int h, Comparator<? super T> c)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2, c);  // bruker midtverdien
        kvikksortering0(a, v, k - 1, c);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h, c);     // sorterer intervallet a[k+1:h]
    }

    private static <T> int sParter0(T[] a, int v, int h, int indeks, Comparator<? super T> c)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h], c);  // partisjonerer a[v:h − 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static <T> int parter0(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && c.compare(a[v], skilleverdi) < 0) v++;   // h er stoppverdi for v
            while (v <= h && c.compare(a[v], skilleverdi) >= 0) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a,a.length/2);   // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length, c);          // kaller metoden over
    }

    private static <T> void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element
        int m = (fra + til)/2;        // midt mellom fra og til

        flettesortering(a,b,fra,m, c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til, c);   // sorterer a[m:til>

        if (c.compare(a[m-1], a[m]) > 0) {
            flett(a,b,fra,m,til, c);  // fletter a[fra:m> og a[m:til>
        }
    }

    public static <T> void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c) {
        int n = m - fra;
        for(int i = 0; i < n; ++i) {
            b[i] = a[i + fra];
        }

        int i = 0;
        int j = m;
        int k = fra;

        while (i < n && j < til) {
            if(c.compare(b[i], a[j]) <= 0) {
                a[k] = b[i];
                i++;

            }
            else {
                a[k] = a[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            a[k] = b[i];
            k++;
            i++;
        }
    }

}