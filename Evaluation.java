import javax.swing.*;
import java.util.Vector;
import java.util.function.Consumer;

/**
 * Created by witzbould on 25.11.2016.
 */
public class Evaluation {
    public Evaluation(Main MyMain) {
        JFrame frame = MyMain.getFrame();
        Vector<Questionnaire> Questionnaires = MyMain.getQuestionnaires();
        JPanel Content = new JPanel();
        Content.setLayout(new BoxLayout(Content,1));

        Questionnaires.forEach(el -> {
            el.setFinalize();
            JScrollPane scrollPane = new JScrollPane(new JTable(el.getData(), new String[]{"Demands", "Rating", "Weight", "Product"}));

            JPanel panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1,1));
            panel1.add(new JLabel(el.getSubjectId()));
            panel1.add(new JLabel(el.getFirstName()));
            panel1.add(new JLabel(el.getLastName()));
            panel1.add(new JLabel(el.getTaskId()));
            panel1.add(new JLabel(el.getTaskName()));
            panel1.add(scrollPane);

            Content.add(panel1);
            Content.add(new JSeparator());
        });

        JButton btnNew = new JButton("New");
        JButton btnSave = new JButton("Save");
        JPanel panel2 = new JPanel();

        panel2.setLayout(new BoxLayout(panel2,2));
        panel2.add(btnNew);
        panel2.add(btnSave);

        Content.add(panel2);

        frame.setContentPane(Content);
        frame.pack();
        frame.setVisible(true);

        btnNew.addActionListener(e -> MyMain.changeState(0));
        btnSave.addActionListener(e -> {
            // do save
            Questionnaires.forEach(el -> {
                try {
                    el.csv_method();
                }
                catch (Exception ex) {
                    new JDialog(frame, "Error while saving!", true);
                }
            });
        });
    }

}
