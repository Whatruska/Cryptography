package RC4;

import Core.CryptoAlgorithm;
import Core.CryptoFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RC4Frame extends CryptoFrame {
    boolean modified = false;
    RC4 algorithm = new RC4(this);
    RC4Form mainForm = new RC4Form(algorithm);

    public RC4Frame(){
        super();
    }

    @Override
    public void action() {
        setContentPane(mainForm.getRootPanel());
        setVisible(true);
        addActions(mainForm);
        mainForm.getEnterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                byte key[] = mainForm.getKeyTextField().getText().getBytes();
                if(key.length > 0){
                    algorithm.setKey(key);
                    modified = true;
                    showSettingsCompleteMessage();
                } else {
                    JOptionPane.showMessageDialog(
                            mainForm.getRootPanel(),
                            "Enter the key",
                            "Key field is empty",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public byte[] getKey(){
        return mainForm.getKeyTextField().getText().getBytes();
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
}
