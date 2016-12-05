import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import java.util.function.Consumer;

/**
 * Created by witzbould on 25.11.2016.
 */
public class Evaluation {
    private JButton SaveBtn = new JButton("Save");
    // Neue umfrage button

    public Evaluation(Main MyMain) {
        JFrame frame = MyMain.getFrame();
        Vector Questionnaires = MyMain.getQuestionnaires();
        JPanel Content = new JPanel(new GridLayout(0,1));
        String[] columnNames = {"Demands", "Rating", "Weight", "Product"};

        Consumer<Questionnaire> buildTable = el -> {
            // finalize Questionnaire
            JPanel panel1 = new JPanel();
            JScrollPane scrollPane = new JScrollPane(new JTable(el.getData(), columnNames));
            panel1.add(new JLabel(el.getSubjectId()));
            panel1.add(new JLabel(el.getFirstName()));
            panel1.add(new JLabel(el.getLastName()));
            panel1.add(new JLabel(el.getTaskId()));
            panel1.add(new JLabel(el.getTaskName()));
            panel1.add(scrollPane);

            Content.add(panel1);
            Content.add(new JSeparator());
        };

        Questionnaires.forEach(buildTable);
        Content.add(SaveBtn);

        frame.setContentPane(Content);
        frame.pack();
        frame.setVisible(true);

        SaveBtn.addActionListener(e -> {
            // do save
        });
    }

}
