import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * Created by witzbould on 25.11.2016.
 */
public class Evaluation {
    public Evaluation(Main MyMain) {
        JFrame frame = MyMain.getFrame();
        Vector<Questionnaire> Questionnaires = MyMain.getQuestionnaires();
        JPanel Content = new JPanel();
        Content.setLayout(new BoxLayout(Content,BoxLayout.PAGE_AXIS));

        Questionnaires.forEach(el -> {
            el.setFinalize();
            JScrollPane scrollPane = new JScrollPane(new JTable(el.getData(), new String[]{"Demands", "Rating", "Weight", "Product"}));
            scrollPane.setPreferredSize(new Dimension(400, 120));
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));

            JPanel panel1 = new JPanel();
            JLabel label1 = new JLabel("Subject ID: ");
            JLabel value1 = new JLabel(el.getSubjectId());
            panel1.add(label1);
            panel1.add(value1);
            panel.add(panel1);

            JPanel panel2 = new JPanel();
            JLabel label2 = new JLabel("First name: ");
            JLabel value2 = new JLabel(el.getFirstName());
            panel2.add(label2);
            panel2.add(value2);
            panel.add(panel2);

            JPanel panel3 = new JPanel();
            JLabel label3 = new JLabel("Last name: ");
            JLabel value3 = new JLabel(el.getLastName());
            panel3.add(label3);
            panel3.add(value3);
            panel.add(panel3);

            JPanel panel4 = new JPanel();
            JLabel label4 = new JLabel("Task ID: ");
            JLabel value4 = new JLabel(el.getTaskId());
            panel4.add(label4);
            panel4.add(value4);
            panel.add(panel4);

            JPanel panel5 = new JPanel();
            JLabel label5 = new JLabel("Task name: ");
            JLabel value5 = new JLabel(el.getTaskName());
            panel5.add(label5);
            panel5.add(value5);
            panel.add(panel5);

            panel.add(Box.createVerticalStrut(10));
            panel.add(scrollPane);
            panel.add(Box.createVerticalStrut(10));

            JPanel panel6 = new JPanel();
            JLabel label6 = new JLabel("Sum of products: ");
            JLabel value6 = new JLabel(String.valueOf(el.getProductSum()));
            panel6.add(label6);
            panel6.add(value6);
            panel.add(panel6);
            JPanel panel7 = new JPanel();
            JLabel label7 = new JLabel("Weights: ");
            JLabel value7 = new JLabel(String.valueOf(el.getWeightSum()));
            panel7.add(label7);
            panel7.add(value7);
            panel.add(panel7);
            JPanel panel8 = new JPanel();
            JLabel label8 = new JLabel("Average: ");
            JLabel value8 = new JLabel(String.valueOf(el.getAverageProduct()));
            panel8.add(label8);
            panel8.add(value8);
            panel.add(panel8);

            Content.add(panel);
            Content.add(new JSeparator());
            Content.add(Box.createVerticalStrut(10));
        });

        JButton btnNew = new JButton("New questionnaire");
        JButton btnSave = new JButton("Save");
        JPanel panel2 = new JPanel();

        panel2.setLayout(new BoxLayout(panel2,BoxLayout.LINE_AXIS));
        panel2.add(btnNew);
        panel2.add(Box.createHorizontalGlue());
        panel2.add(btnSave);

        Content.add(panel2);
        Content.add(Box.createVerticalStrut(10));

        frame.setContentPane(Content);
        frame.pack();
        frame.setVisible(true);

        btnNew.addActionListener(e -> MyMain.changeState(0));
        btnSave.addActionListener(e -> {
            // do save
            Questionnaires.forEach(el -> {
                try {
                    el.csv_method();
                    JOptionPane.showMessageDialog(frame,
                            "The file \"" + el.getFilename() + "\" was successfully saved alongside the jar.",
                            "Successfully saved",
                            JOptionPane.PLAIN_MESSAGE
                    );
                }
                catch (Exception ex) {
                    JOptionPane.showConfirmDialog(frame,
                            "There occurred an error while saving the file \"" + el.getFilename() + "\".",
                            "Error while saving!",
                            JOptionPane.ERROR_MESSAGE,
                            JOptionPane.OK_OPTION
                    );
                }
            });
        });
    }

}
