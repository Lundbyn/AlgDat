public class Main {

    public static void main(String[] args) {

        String[] s = {"Hei", "Paa", "Deg"};

        TabellListe<String> liste = new TabellListe<>(s);

        System.out.println(liste.toString());

        liste.nullstill();

        System.out.println(liste.toString());

    }

}
