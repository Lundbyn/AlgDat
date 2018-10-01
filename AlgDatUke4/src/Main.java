import eksempelklasser.*;

import java.util.Arrays;

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
        */
        Student[] s = new Student[6];                             // en studenttabell
        s[0] = new Student("Kari","Svendsen", Studium.Data);      // Kari Svendsen
        s[1] = new Student("Boris","Zukanovic", Studium.IT);      // Boris Zukanovic
        s[2] = new Student("Ali","Kahn", Studium.Anvendt);        // Ali Kahn
        s[3] = new Student("Azra","Zukanovic", Studium.IT);       // Azra Zukanovic
        s[4] = new Student("Kari","Pettersen", Studium.Data);     // Kari Pettersen
        s[5] = new Student("Mathias", "Lundby", Studium.Elektro);

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
    }
}
