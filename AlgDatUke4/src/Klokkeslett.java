public class Klokkeslett implements Comparable<Klokkeslett> {


    private final String tid;

    public Klokkeslett(String tid) {
        this.tid = tid;
    }

    public int compareTo(Klokkeslett k) {
        for(int i = 0; i < tid.length(); i++) {
            if(this.tid.charAt(i) > k.tid.charAt(i)) {
                return 1;
            }
            if(this.tid.charAt(i) < k .tid.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }


    public String toString() {
        return "Kl " + tid;
    }


}
