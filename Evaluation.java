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

            JPanel panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1,BoxLayout.PAGE_AXIS));
            panel1.add(new JLabel(el.getSubjectId()));
            panel1.add(new JLabel(el.getFirstName()));
            panel1.add(new JLabel(el.getLastName()));
            panel1.add(new JLabel(el.getTaskId()));
            panel1.add(new JLabel(el.getTaskName()));
            panel1.add(scrollPane);
            panel1.add(new JLabel( String.valueOf(el.getProductSum())));
            panel1.add(new JLabel( String.valueOf(el.getWeightSum())));
            panel1.add(new JLabel( String.valueOf(el.getAverageProduct())));

            Content.add(panel1);
            Content.add(new JSeparator());
        });

        JButton btnNew = new JButton("New");
        JButton btnSave = new JButton("Save");
        JPanel panel2 = new JPanel();

        panel2.setLayout(new BoxLayout(panel2,BoxLayout.LINE_AXIS));
        panel2.add(btnNew);
        panel2.add(Box.createHorizontalGlue());
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
                    JOptionPane.showMessageDialog(frame,
                            "The file was successfully saved alongside the jar.",
                            "Successfully saved",
                            JOptionPane.PLAIN_MESSAGE
                    );
                }
                catch (Exception ex) {
                    JOptionPane.showConfirmDialog(frame,
                            "There occurred an error while saving the file.",
                            "Error while saving!",
                            JOptionPane.ERROR_MESSAGE,
                            JOptionPane.OK_OPTION
                    );
                }
            });
        });
    }

}
