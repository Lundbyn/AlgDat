import hjelpeklasser.EnkeltLenketListe;
import hjelpeklasser.Liste;
import hjelpeklasser.TabellListe;

import java.util.Iterator;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        System.out.println("Kjør");

        /*
        String[] s = {"Hei", "Paa", null, "Deg!", "LELELELELELE", "Deg!"};
        TabellListe<String> liste = new TabellListe<>(s);

        System.out.println(liste.toString());
        */
/*
        String[] s = {"Per","Kari","Ole"};

        Liste<String> liste = new TabellListe<>();

        for (String navn : s) liste.leggInn(navn);

        System.out.println(liste);

        Iterator<String> i = liste.iterator();     // oppretter en iterator i
        Iterator<String> j = liste.iterator();     // oppretter en iterator j

        System.out.println(i.next());              // den første i listen
        i.remove();                                // fjerner den første
        System.out.println(j.next());
*/

        Integer[] i = {null,2,6,null,0,5};
        EnkeltLenketListe ell = new EnkeltLenketListe(i);

        System.out.println(ell.inneholder(2));

    }
}
