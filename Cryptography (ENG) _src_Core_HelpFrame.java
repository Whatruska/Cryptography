package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelpFrame extends JFrame {

    HelpForm mainForm = new HelpForm();

    public HelpFrame(){
        setContentPane(mainForm.getRootPanel());
        setMinimumSize(Resources.CRYPTOFRAME_DIMENSION);
        setMaximumSize(Resources.CRYPTOFRAME_MAX_DIMENSION);
        setTitle("Science Society of Students. Algorithms of encoding. Helps and Instructions.");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        mainForm.getHomeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                dispose();
            }
        });

        mainForm.getTextArea1().setText(Resources.FIRST_DESC);
        mainForm.getTextArea2().setText(Resources.SECOND_DESC);
        mainForm.getTextArea3().setText(Resources.THIRD_DESC);
        mainForm.getTextArea4().setText(Resources.FINAL_DESC);
    }
}
