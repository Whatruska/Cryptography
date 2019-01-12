package Core;

import javax.swing.*;

public class MainForm {
    private JPanel rootPanel;
    private JComboBox algorithmComboBox;
    private JButton confirmButton;
    private JLabel bottomSpacer;
    private JLabel leftSpacer;
    private JLabel rightSpacer;
    private JLabel topSpacer;
    private JLabel firstMiddleSpacer;
    private JButton helpButton;
    private JLabel secondMiddleSpacer;

    public JButton getHelpButton() {
        return helpButton;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JComboBox getAlgorithmComboBox() {
        return algorithmComboBox;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

}
