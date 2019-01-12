package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract public class CryptoFrame extends JFrame {

    public final static int SOURCE_TEXT_AREA_NOT_FILLED = 0;
    public final static int NOT_MODIFIED = 1;
    public final static int EVERYTHING_IS_FINE = 2;
    public final static int ENCRYPT_MOD = 3;
    public final static int DECRYPT_MOD = 4;

    CryptoForm mainForm;

    public CryptoFrame(){}

    public void init(CryptoAlgorithm algorithm){
        setMinimumSize(Resources.CRYPTOFRAME_DIMENSION);
        setPreferredSize(Resources.CRYPTOFRAME_DIMENSION);
        setMaximumSize(Resources.CRYPTOFRAME_MAX_DIMENSION);
        setLocationRelativeTo(null);
        setTitle(algorithm.getClass().getSimpleName() + " encoding");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showSettingsCompleteMessage(){
        JOptionPane.showMessageDialog(
                mainForm.getRootPanel(),
                "Algorithm`s setting went successfully",
                "Algorithm settings",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void addActions(CryptoForm form){
        mainForm = form;
        mainForm.returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                dispose();
            }
        });

        mainForm.encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useAlgorithm(ENCRYPT_MOD);
            }
        });

        mainForm.decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useAlgorithm(DECRYPT_MOD);
            }
        });
    }

    private void useAlgorithm(int mod){
        int status = status();
        if (status == EVERYTHING_IS_FINE){
            if (mod == ENCRYPT_MOD){
                mainForm.resultTextArea.setText(Resources.bytesToString(mainForm.algorithm.encrypt(mainForm.getData())));
            } else if (mod == DECRYPT_MOD){
                mainForm.resultTextArea.setText(Resources.bytesToString(mainForm.algorithm.decrypt(mainForm.getData())));
            }
        } else if(status == SOURCE_TEXT_AREA_NOT_FILLED){
            JOptionPane.showMessageDialog(
                    mainForm.getRootPanel(),
                    "Fill the << Source text >> field",
                    "Field is empty",
                    JOptionPane.ERROR_MESSAGE
            );
        } else if(status == NOT_MODIFIED){
            JOptionPane.showMessageDialog(
                    mainForm.getRootPanel(),
                    "Follow the setting`s block instructions",
                    "Algorithm is not setted",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public abstract void action();
    public abstract int status();
}
