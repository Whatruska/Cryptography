package RC4;

import Core.CryptoAlgorithm;
import Core.CryptoForm;

import javax.swing.*;

public class RC4Form extends CryptoForm {
    private JLabel topSpacer;
    private JLabel bottomSpacer;
    private JLabel leftSpacer;
    private JLabel rightSpacer;
    private JPanel rootPanel;
    private JPanel textPanel;
    private JLabel sourceTextLabel;
    private JTextArea sourceTextArea;
    private JLabel resultTextLabel;
    private JTextArea resultTextArea;
    private JLabel textSpacer;
    private JPanel buttonPanel;
    private JButton decryptButton;
    private JButton encryptButton;
    private JLabel buttonSpacer;
    private JButton returnButton;
    private JPanel keySettingsPanel;
    private JButton enterButton;
    private JTextField keyTextField;
    private JLabel enterTheKeyButton;

    public JPanel getTextPanel() {
        return textPanel;
    }

    public JTextArea getSourceTextArea() {
        return sourceTextArea;
    }

    public JTextArea getResultTextArea() {
        return resultTextArea;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

    public JPanel getKeySettingsPanel() {
        return keySettingsPanel;
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    public JTextField getKeyTextField() {
        return keyTextField;
    }

    public RC4Form(CryptoAlgorithm algorithm) {
        super.algorithm = algorithm;
        super.decryptButton = this.decryptButton;
        super.encryptButton = this.encryptButton;
        super.returnButton = this.returnButton;
        super.rootPanel = this.rootPanel;
        super.sourceTextArea = this.sourceTextArea;
        super.resultTextArea = this.resultTextArea;
    }

    private void createUIComponents() {
        rootPanel = new JPanel();
    }
}
