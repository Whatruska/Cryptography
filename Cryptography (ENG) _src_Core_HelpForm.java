package Core;

import javax.swing.*;

public class HelpForm {
    private JLabel topSpacer;
    private JLabel rightSpacer;
    private JLabel leftSpacer;
    private JLabel bottomSpacer;
    private JPanel rootPanel;
    private JButton homeButton;
    private JPanel bodyPanel;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JLabel firstDescription;
    private JLabel secondDescription;
    private JLabel thirdDescription;
    private JLabel finalDescription;
    private JPanel headPanel;
    private JPanel middlePanel;
    private JPanel finalPanel;

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public JTextArea getTextArea2() {
        return textArea2;
    }

    public JTextArea getTextArea3() {
        return textArea3;
    }

    public JTextArea getTextArea4() {
        return textArea4;
    }

    public JLabel getFirstDescription() {
        return firstDescription;
    }

    public JLabel getSecondDescription() {
        return secondDescription;
    }

    public JLabel getThirdDescription() {
        return thirdDescription;
    }

    public JLabel getFinalDescription() {
        return finalDescription;
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JPanel getBodyPanel() {
        return bodyPanel;
    }

    public JPanel getHeadPanel() {
        return headPanel;
    }

    public JPanel getMiddlePanel() {
        return middlePanel;
    }

    public JPanel getFinalPanel() {
        return finalPanel;
    }
}
