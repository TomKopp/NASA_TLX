import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marco on 18.11.2016.
 */
public class MainGUI {
    private JSlider slider2;
    private JLabel result1;
    private JLabel result2;
    private JPanel panel;
    private JButton submitButton;
    private JSlider slider3;
    private JSlider slider4;
    private JSlider slider5;
    private JSlider slider6;
    private JSlider slider1;
    private JLabel result3;
    private JLabel result4;
    private JLabel result5;
    private JLabel result6;

    public ChangeListener listener1 = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

        }
    };

    public MainGUI() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int ergebnisZahl = slider2.getValue();
                result2.setText("" + ergebnisZahl);
            }}
        );
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider1.getValue();
                result1.setText("" + aktuelleZahl);
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider2.getValue();
                result2.setText("" + aktuelleZahl);
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider3.getValue();
                result3.setText("" + aktuelleZahl);
            }
        });
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider4.getValue();
                result4.setText("" + aktuelleZahl);
            }
        });
        slider5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider5.getValue();
                result5.setText("" + aktuelleZahl);
            }
        });
        slider6.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider6.getValue();
                result6.setText("" + aktuelleZahl);
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainGUI");
        frame.setContentPane(new MainGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }




}
