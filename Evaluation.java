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

//        String[] headers = {
//                "Demands",
//                "Rating",
//                "Weight",
//                "Product"
//        };
//        Object[][] data = {{"baum", "blubber", 5, 5}};
//        Evaluation = new JTable(data, headers);

//        Evaluation.setValueAt("Demands", 0,0);
//        Evaluation.setValueAt("Rating", 0, 1);
//        Evaluation.setValueAt("Weight", 0,2);
//        Evaluation.setValueAt("Product", 0,3);
    }

}
