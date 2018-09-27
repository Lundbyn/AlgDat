import eksempelklasser.Heltall;
import eksempelklasser.Studium;

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
*/

        for (Studium s : Studium.values()) {
            System.out.println(s.toString() + " (" + s.name() + ")");
        }

    }
}
