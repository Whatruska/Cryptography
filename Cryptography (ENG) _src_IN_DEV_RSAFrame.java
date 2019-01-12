package IN_DEV;

import Core.CryptoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RSAFrame extends CryptoFrame {

    final static int P_NOT_FILLED = -1;
    final static int Q_NOT_FILLED = -2;
    final static int D_NOT_FILLED = -3;
    final static int N_NOT_FILLED = -4;
    final static int P_AND_Q_IS_NOT_SIMPLE = -5;
    final static int SETTINGS_IS_CORRECT = -6;
    final static Pattern NUMBER_FORMAT = Pattern.compile("[0-9]+");

    RSA algorithm = new RSA(this);
    RSAForm mainForm = new RSAForm(algorithm);
    boolean modified = false;

    public RSAFrame(){
        super();
    }

    private static boolean isCorrect(String string){
        Matcher m = NUMBER_FORMAT.matcher(string);
        return m.matches();
    }
    //Checks if text in numeric format

    @Override
    public void action() {
        setContentPane(mainForm.getRootPanel());
        setVisible(true);
        addActions(mainForm);
        mainForm.getConfirmButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int status = checkSettingStatus();
                if (status == P_NOT_FILLED){
                    JOptionPane.showMessageDialog(
                            mainForm.getRootPanel(),
                            "Incorrect input in P field",
                            "Incorrect input",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (status == Q_NOT_FILLED){
                    JOptionPane.showMessageDialog(
                            mainForm.getRootPanel(),
                            "Incorrect input in Q field",
                            "Incorrect input",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (status == D_NOT_FILLED){
                    JOptionPane.showMessageDialog(
                            mainForm.getRootPanel(),
                            "Incorrect input in D field",
                            "Incorrect input",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (status == N_NOT_FILLED){
                    JOptionPane.showMessageDialog(
                            mainForm.getRootPanel(),
                            "Incorrect input in N field",
                            "Incorrect input",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if(status == P_AND_Q_IS_NOT_SIMPLE){
                    JOptionPane.showMessageDialog(
                            mainForm.getRootPanel(),
                            "Numbers P and Q aren`t simple",
                            "Incorrect input",
                            JOptionPane.ERROR_MESSAGE
                    );
                } else if (status == SETTINGS_IS_CORRECT){
                    showSettingsCompleteMessage();
                    modified = true;
                    algorithm.setSettings(getSettings());
                }
            }
        });
    }

    public RSASettings getSettings(){
        return new RSASettings(
                mainForm.getpTextField().getText(),
                mainForm.getqTextField().getText(),
                mainForm.getdTextField().getText(),
                mainForm.getnTextField().getText()
        );
    }

    private int checkSettingStatus(){
        String p = mainForm.getpTextField().getText();
        String q = mainForm.getqTextField().getText();
        String d = mainForm.getdTextField().getText();
        String n = mainForm.getnTextField().getText();

        if (!isCorrect(p)){
            return P_NOT_FILLED;
        } else if (!isCorrect(q)){
            return Q_NOT_FILLED;
        } else if (!isCorrect(d)){
            return D_NOT_FILLED;
        } else if (!isCorrect(n)){
            return N_NOT_FILLED;
        } else if (!isTheNumberSimple(Long.parseLong(p)) || !isTheNumberSimple(Long.parseLong(q))){
            return P_AND_Q_IS_NOT_SIMPLE;
        } else {
            return SETTINGS_IS_CORRECT;
        }
    }

    @Override
    public int status() {
        byte[] data = mainForm.getData();
        if (data.length > 0){
            if (modified){
                return EVERYTHING_IS_FINE;
            } else {
                return NOT_MODIFIED;
            }
        } else {
            return SOURCE_TEXT_AREA_NOT_FILLED;
        }
    }

    public static boolean isTheNumberSimple(long n)
    {
        if (n < 2)
            return false;

        if (n == 2)
            return true;

        for (long i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
