package IN_DEV;

public class RSASettings {
    private String p;
    private String q;
    private String d;
    private String n;

    public RSASettings(String p, String q, String d, String n) {
        this.p = p;
        this.q = q;
        this.d = d;
        this.n = n;
    }

    public int getP() {
        return Integer.parseInt(p);
    }

    public int getQ() {
        return Integer.parseInt(q);
    }

    public int getD() {
        return Integer.parseInt(d);
    }

    public int getN() {
        return Integer.parseInt(n);
    }
}
