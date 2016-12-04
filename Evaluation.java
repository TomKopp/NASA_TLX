import javax.swing.*;

/**
 * Created by witzbould on 25.11.2016.
 */
public class Evaluation {
    private JTable Evaluation;
    private JPanel panel1;

    public Evaluation(Main MyMain) {
        JFrame frame = MyMain.getFrame();
        frame.setContentPane(this.panel1);
        frame.pack();
        frame.setVisible(true);

        Evaluation.setValueAt("Demands", 1,1);
        Evaluation.setValueAt("Rating", 1, 2);
        Evaluation.setValueAt("Weight", 1,3);
        Evaluation.setValueAt("Product", 1,4);
    }

}
