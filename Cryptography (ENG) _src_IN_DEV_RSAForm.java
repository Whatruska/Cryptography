package IN_DEV;

import Core.CryptoAlgorithm;
import Core.CryptoForm;

import javax.swing.*;

public class RSAForm extends CryptoForm {
    private JLabel topSpacer;
    private JLabel leftSpacer;
    private JLabel rightSpacer;
    private JLabel bottomSpacer;
    private JLabel nameLabel;
    private JPanel rootPanel;
    private JPanel textPanel;
    private JPanel keySettingsPanel;
    private JTextArea sourceTextArea;
    private JTextArea resultTextArea;
    private JLabel sourceTextLabel;
    private JLabel resultTextLabel;
    private JLabel textSpacer;
    private JButton decryptButton;
    private JButton encryptButton;
    private JPanel buttonPanel;
    private JLabel pKeyLabel;
    private JLabel qKeyLabel;
    private JLabel buttonSpacer;
    private JLabel keySpacer;
    private JTextField qTextField;
    private JTextField pTextField;
    private JLabel middleSpacer;
    private JLabel privateKeyLabel;
    private JTextField dTextField;
    private JButton confirmButton;
    private JLabel nKeyLabel;
    private JButton returnButton;
    private JLabel publicLabel;
    private JTextField nTextField;
    private JLabel secondMiddleSpacer;
    private JLabel dKeyLabel;

    public JPanel getTextPanel() {
        return textPanel;
    }

    public JTextArea getSourceTextArea() {
        return sourceTextArea;
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }

    public JButton getDecryptButton() {
        return decryptButton;
    }

    public JButton getEncryptButton() {
        return encryptButton;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JTextField getqTextField() {
        return qTextField;
    }

    public JTextField getpTextField() {
        return pTextField;
    }

    public JTextField getdTextField() {
        return dTextField;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JTextField getnTextField() {
        return nTextField;
    }

    public RSAForm(CryptoAlgorithm algorithm){
        super.algorithm = algorithm;
        super.returnButton = this.returnButton;
        super.decryptButton = this.decryptButton;
        super.encryptButton = this.encryptButton;
        super.rootPanel = this.rootPanel;
        super.sourceTextArea = this.sourceTextArea;
        super.resultTextArea = this.resultTextArea;
    }

    private void createUIComponents() {
        rootPanel = new JPanel();
    }
}
