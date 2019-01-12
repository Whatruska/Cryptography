package IN_DEV;

import Core.CryptoAlgorithm;
import Core.Resources;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;

public class RSA extends CryptoAlgorithm {

    private char[] characters = "01234567890()QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm!@#№$?,.[]{}-+=_".toCharArray();

    private RSAFrame mainFrame;
    private RSASettings settings;

    public void setSettings(RSASettings settings) {
        this.settings = settings;
    }

    public RSA(RSAFrame frame){
        mainFrame = frame;
    }

    @Override
    protected byte[] encrypt(byte[] data) {
        makeSettings();
        long n = settings.getP() * settings.getQ();
        long m = (settings.getP() - 1) * (settings.getQ() - 1);
        long d = calculateD(m);
        long e_ = calculateE(d,m);

        LinkedList<String> result = RSAendoce(Resources.bytesToString(data),e_,n);
        return Resources.listToBytes(result);
    }

    @Override
    protected byte[] decrypt(byte[] data) {
        makeSettings();
        long d = settings.getD();
        long n = settings.getN();
        return RSAdedoce(data,d,n).getBytes();
    }

    @Override
    protected void makeSettings() {
        setSettings(mainFrame.getSettings());
    }

    private LinkedList<String> RSAendoce(String s, long e, long n)
    {
        LinkedList<String> result = new LinkedList<>();

        BigInteger bi;

        for (int i = 0; i < s.length(); i++)
        {
            int index = Arrays.binarySearch(characters, s.charAt(i));

            bi = new BigInteger(Integer.toString(index));
            bi = bi.pow((int)e);

            BigInteger n_ = new BigInteger(Integer.toString((int)n));

            bi = bi.mod(new BigInteger(Long.toString(n)));

            result.add(bi.toString());
        }

        return result;
    }

    private String RSAdedoce(byte[] input, long d, long n)
    {
        StringBuilder resultBuilder = new StringBuilder("");

        BigInteger bi;

        for(byte item : input)
        {
            bi = new BigInteger(Byte.toString(item));
            bi = bi.pow((int)d);

            BigInteger n_ = new BigInteger(Integer.toString((int)n));

            bi = bi.mod(n_);

            int index = bi.intValue();

            resultBuilder.append(characters[index]);
        }

        return resultBuilder.toString();
    }

    private long calculateD(long m)
    {
        long d = m - 1;

        for (long i = 2; i <= m; i++)
            if ((m % i == 0) && (d % i == 0)) //если имеют общие делители
            {
                d--;
                i = 1;
            }

        return d;
    }

    private long calculateE(long d, long m)
    {
        long e = 10;

        while (true)
        {
            if ((e * d) % m == 1)
                break;
            else
                e++;
        }

        return e;
    }
}
