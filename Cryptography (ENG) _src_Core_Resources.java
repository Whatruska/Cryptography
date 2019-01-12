package Core;

import RC4.*;
import com.sun.xml.internal.ws.util.ASCIIUtility;

import java.awt.*;
import java.util.*;

public class Resources {

    public static final String link ="";

    public static final String FIRST_DESC = "Welcome! This page is explaining how this app works.\n" +
            "All algorithms contains three blocks.\nFirst block includes two text fields : \n" +
            "One - for source text, another for output text.\n";
    public static final String SECOND_DESC = "Second block is settings block.\n" +
            "It`s higly individual for each algorithm and there no way to find common look of this form\n" +
            "It`s under the first block";
    public static final String THIRD_DESC = "Third block is a control block, containing 3 buttons :\n << Encode >>, << Decode >> и << Home >>\n" +
            "First and second buttons won`t work, if you haven`t input source text and hadn`t followed the setting block instructions\n" +
            "Last button just returning user to home page";
    public static final String FINAL_DESC = "That`s all.\nYou can download source code and add your own cryptoalgorithms" +
            "\nInstruction attached to project may help you.\nAll materials are here : " + link;
    //HelpFrame descritions


    public static final int MAINFRAME_DEFAULT_WIDTH = 400;
    public static final int MAINFRAME_DEFAULT_HEIGTH = 300;

    public static final int CRYPTOFRAME_DEFAULT_WIDTH = 800;
    public static final int CRYPTOFRAME_DEFAULT_HEIGTH = 600;

    public static final int CRYPTOFRAME_MAX_WIDTH = 1200;
    public static final int CRYPTOFRAME_MAX_HEIGTH = 900;

    public static final HashMap<Class,CryptoFrame> FRAME_HASH_MAP = createFrameMap();
    private static HashMap<Class,CryptoFrame> createFrameMap(){
        HashMap<Class,CryptoFrame> hashMap = new HashMap<>();

        //Add here your CryptoAlgorithms as example
        //hashMap.put(RSA.class, new RSAFrame());
        
        hashMap.put(RC4.class, new RC4Frame());

        return hashMap;
    }
    //Returns HashMap that helps to switch frames

    public static final CryptoAlgorithm[] CRYPTOALGORITHMS = new CryptoAlgorithm[]{
            new RC4(new RC4Frame())
            //, new RSA(new RSAFrame())
    };
    //Add your CryptoAlgorithm object to put it on MainFrame ComboBox

    public static final Dimension CRYPTOFRAME_DIMENSION = new Dimension(CRYPTOFRAME_DEFAULT_WIDTH,CRYPTOFRAME_DEFAULT_HEIGTH);
    public static final Dimension CRYPTOFRAME_MAX_DIMENSION = new Dimension(CRYPTOFRAME_MAX_WIDTH,CRYPTOFRAME_MAX_HEIGTH);
    public static final Dimension MAINFRAME_DIMENSION = new Dimension(MAINFRAME_DEFAULT_WIDTH,MAINFRAME_DEFAULT_HEIGTH);

    public static String[] getAlgorithmsNames() {
        CryptoAlgorithm[] algorithms = CRYPTOALGORITHMS;
        ArrayList<String> names = new ArrayList<>();

        for (CryptoAlgorithm algorithm : algorithms){
            names.add(algorithm.getClass().getSimpleName());
        }

        return names.toArray(new String[names.size()]);
    }

    public static CryptoAlgorithm getSelectedAlgorithm() throws Exception {
        return getAlgorithmByName((String) MainFrame.mainForm.getAlgorithmComboBox().getSelectedItem());
    }
    //Returns algorithm selected by user

    public static CryptoAlgorithm getAlgorithmByName(String name) throws Exception {
        HashMap<String, CryptoAlgorithm> algorithmHashMap = Resources.getControlMap();
        return algorithmHashMap.get(name);
    }

    public static HashMap<String, CryptoAlgorithm> getControlMap() throws Exception {
        CryptoAlgorithm[] algorithms = CRYPTOALGORITHMS;
        String[] names = getAlgorithmsNames();
        HashMap<String, CryptoAlgorithm> result = new HashMap<>();

        for (int i = 0; i< algorithms.length; i++){
            String name = names[i];
            CryptoAlgorithm algorithm = algorithms[i];

            result.put(name, algorithm);
        }

        return result;
    }
    //Returns HashMap<String, CryptoAlgorithm> which helps to choose correct frame at MainFrame

    public static byte[] listToBytes(LinkedList<String> list){
        StringBuilder builder = new StringBuilder("");
        for (String string : list){
            builder.append(string);
        }
        return builder.toString().getBytes();
    }
    //Performs LinkedList to byte array

    public static String bytesToString(byte[] data){
        return ASCIIUtility.toString(data,0,data.length);
    }
    //Performs byte array to string
}
