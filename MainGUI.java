import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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

    private String pd = "PD";
    private String td = "TD";
    private String md = "MD";
    private String op = "OP";
    private String fr = "FR";
    private String ef = "EF";

    private HashMap<String, Integer> DemandsAndRatings;

    public ChangeListener listener1 = new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {

        }
    };

    public MainGUI(Main MyMain) {
        Questionnaire CurrentQuestionnaire = MyMain.getCurrentQuestionnaire();
        JFrame frame = MyMain.getFrame();
        frame.setContentPane(this.panel);
        frame.pack();
        frame.setVisible(true);

        this.DemandsAndRatings = new HashMap<String, Integer>();


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (String key: DemandsAndRatings.keySet()) {
                    CurrentQuestionnaire.addRaiting(key, DemandsAndRatings.get(key));
                }
                MyMain.changeState(2);
            }}
        );
        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider1.getValue();
                result1.setText("" + aktuelleZahl);
                DemandsAndRatings.put(md, aktuelleZahl);
            }
        });
        slider2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider2.getValue();
                result2.setText("" + aktuelleZahl);
                DemandsAndRatings.put(pd, aktuelleZahl);
            }
        });
        slider3.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider3.getValue();
                result3.setText("" + aktuelleZahl);
                DemandsAndRatings.put(td, aktuelleZahl);
            }
        });
        slider4.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider4.getValue();
                result4.setText("" + aktuelleZahl);
                DemandsAndRatings.put(op, aktuelleZahl);
            }
        });
        slider5.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider5.getValue();
                result5.setText("" + aktuelleZahl);
                DemandsAndRatings.put(fr, aktuelleZahl);
            }
        });
        slider6.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int aktuelleZahl = slider6.getValue();
                result6.setText("" + aktuelleZahl);
                DemandsAndRatings.put(ef, aktuelleZahl);
            }
        });

    }





}
