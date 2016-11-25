import javax.swing.*;

/**
 * Created by witzbould on 25.11.2016.
 */
public class Evaluation {
    private JTable Evaluation;
    private JPanel panel1;

    public Evaluation() {
        Evaluation.setValueAt("Demands", 0,0);
        Evaluation.setValueAt("Rating", 0, 1);
        Evaluation.setValueAt("Weight", 0,2);
        Evaluation.setValueAt("Product", 0,3);
    }

    public void main() {
        JFrame frame = new JFrame("Evaluation");
        frame.setContentPane(new Evaluation().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
