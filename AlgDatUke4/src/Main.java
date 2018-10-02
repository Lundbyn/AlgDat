import eksempelklasser.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        /*
        double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Double[] D = new Double[d.length];

        for(int i = 0; i < D.length; i++) {
            D[i] = d[i];
        }

        Tabell.innsettingssortering(D);

        System.out.println(Arrays.toString(D));


        for (Studium s : Studium.values()) {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }

        for (Maned m : Maned.values())
        {
            System.out.println(m.toString() + " (" + m.name() + ")");
        }


        Student[] s = new Student[6];                             // en studenttabell
        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        s[5] = new Student("Mathias", "Lundby", Studium.Elektro);

        //Oppgave 1.4.6 3
        Tabell.innsettingssortering(s,
                (s1,s2) ->
                {
                    int k = s1.studium().compareTo(s2.studium());
                    if (k != 0) return k;
                    k = s1.fornavn().compareTo(s2.fornavn());
                    if (k != 0) return k;
                    return s1.etternavn().compareTo(s2.etternavn());
                }
        );
        System.out.println(Arrays.toString(s));

        //Oppgave 1.4.6 5
        //String[] sTall = {"21","18","8","13","20","6","16","25","3","10"};

        Tabell.innsettingssortering(s, (s1,s2) -> {
            int k = s1.length() - s2.length();
            return k != 0 ? k : s1.compareTo(s2);
        });

        System.out.println(Arrays.toString(s));

        Komparator<Student> c = (s1,s2) ->
        {
            int cmp = s1.studium().name().compareTo(s2.studium().name());
            return cmp != 0 ? cmp : s1.compareTo(s2);
        };

        Tabell.innsettingssortering(s, c);    // Programkode 1.4.6 b)
        System.out.println(Arrays.toString(s));


        Double[] d = {5.7,3.14,7.12,3.9,6.5,7.1,7.11};
        Tabell.innsettingssortering(d, Komparator.naturligOrden());
        Tabell.innsettingssortering(d, Komparator.omvendtOrden());

        Boolean[] b = {false, true, true, false, false, true, false, true};
        Tabell.innsettingssortering(b, Komparator.naturligOrden());

        Tabell.innsettingssortering(s, Komparator.orden(Student::etternavn));

        String[] navn = {"Lars","Anders","Bodil","Kari","Per","Berit"};
        //Tabell.innsettingssortering(navn, Komparator.orden(x-> -x.length()));

        //Tabell.innsettingssortering(sTall, Komparator.orden(String::length).deretter(x -> x));



        //1.4.9

        String[] s = {"Sohil","Per","Thanh","Ann","Kari","Jon"};       // String-tabell

        Comparator<String> c =  Comparator.comparing(String::length);  // etter lengde
        Tabell.innsettingssortering(s, c.thenComparing(x -> x));       // vanlig orden
        System.out.println(Arrays.toString(s));


        //Integer[] tabell = {1,0,4,6,29,4,68,2,3,6,4,3,6,4};


        Dato[] d = new Dato[5];           // en datotabell
        d[0] = new Dato(24,12,2014);      // 24/12-2014
        d[1] = new Dato(24,12,2012);      // 24/12-2012
        d[2] = new Dato(9,12,2013);       // 9/12-2013
        d[3] = new Dato(25,12,2012);      // 25/12-2012
        d[4] = new Dato(10,12,2013);      // 10/12-2013

        Tabell.innsettingssortering(d);
        for (Dato x : d) System.out.print(x + " ");

        // Utskrift: 24/12-2012 25/12-2012 9/12-2013 10/12-2013 24/12-2014

        Klokkeslett[] k = new Klokkeslett[4];
        k[0] = new Klokkeslett("00:15");
        k[1] = new Klokkeslett("23:59");
        k[2] = new Klokkeslett("13:45");
        k[3] = new Klokkeslett("00:00");
        Tabell.innsettingssortering(k);
        System.out.println(Arrays.toString(k));
        */

        //Kap 3
        //Oppgave ..

    }
}
