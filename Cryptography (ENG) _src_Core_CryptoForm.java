package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract public class CryptoForm {
     protected CryptoAlgorithm algorithm;
     protected JPanel rootPanel;
     protected JTextArea sourceTextArea;
     protected JTextArea resultTextArea;
     protected JButton returnButton;
     protected JButton decryptButton;
     protected JButton encryptButton;

     public CryptoAlgorithm getAlgorithm() {
          return algorithm;
     }

     public byte[] getData(){
          return sourceTextArea.getText().getBytes();
     }

     public JPanel getRootPanel(){
          return rootPanel;
     };
}
