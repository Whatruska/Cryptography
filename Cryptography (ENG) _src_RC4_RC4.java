package RC4;

import Core.CryptoAlgorithm;

public class RC4 extends CryptoAlgorithm {
    final static int S_BLOCK_SIZE = 128;
    byte[] s = new byte[S_BLOCK_SIZE];
    private int x = 0;
    private int y = 0;
    byte[] key;
    RC4Frame mainFrame;

    public void setKey(byte[] key) {
        this.key = key;
    }

    public RC4(RC4Frame frame){
        mainFrame = frame;
    }

    @Override
    protected byte[] encrypt(byte[] data) {
        makeSettings();
        byte[] cipher = new byte[data.length];

        for (int m = 0; m < data.length; m++){
            cipher[m] = (byte)(data[m] ^ keyItem());
        }
        return cipher;
    }

    @Override
    protected byte[] decrypt(byte[] data) {
        makeSettings();
        return encrypt(data);
    }

    @Override
    protected void makeSettings() {
        setKey(mainFrame.getKey());
        init();
    }

    private void init(){
        int keyLength = key.length;
        x = 0;
        y = 0;

        for (int i = 0; i < S_BLOCK_SIZE; i++){
            s[i] = (byte)i;
        }

        int j = 0;
        for (int i = 0; i < S_BLOCK_SIZE; i++){
            j = (j + s[i] + key[i % keyLength]) % S_BLOCK_SIZE;
            swap(i,j);
        }
    }

    private void swap(int index1, int index2){
        try{
            byte temp = s[index1];
            s[index1] = s[index2];
            s[index2] = temp;
        } catch (Exception e){
            System.out.println(index1 + " " + index2);
        }
    }

    private byte keyItem(){
        x = (x + 1) % S_BLOCK_SIZE;
        y = (y + s[x]) % S_BLOCK_SIZE;
        swap(x,y);
        return s[(s[x] + s[y]) % S_BLOCK_SIZE];
    }

}
