package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static MainForm mainForm = new MainForm();

    public MainFrame(){
        setContentPane(mainForm.getRootPanel());
        setMinimumSize(Resources.MAINFRAME_DIMENSION);
        setMaximumSize(Resources.CRYPTOFRAME_DIMENSION);
        setTitle("Science Society of Students. Algorithms of encoding.");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        mainForm.getAlgorithmComboBox().removeAllItems();

        String[] names = Resources.getAlgorithmsNames();
        for (String name : names){
            mainForm.getAlgorithmComboBox().addItem(name);
        }

        mainForm.getConfirmButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CryptoAlgorithm selectedAlgorithm = Resources.getSelectedAlgorithm();
                    CryptoFrame cryptoFrame = Resources.FRAME_HASH_MAP.get(selectedAlgorithm.getClass());
                    cryptoFrame.init(selectedAlgorithm);
                    cryptoFrame.action();
                    dispose();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        mainForm.getHelpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HelpFrame();
                dispose();
            }
        });
    }
}
