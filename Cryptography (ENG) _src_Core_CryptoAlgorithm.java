package Core;

abstract public class CryptoAlgorithm {
    abstract protected byte[] encrypt(byte[] data);
    abstract protected byte[] decrypt(byte[] data);
    abstract protected void makeSettings();
}
