import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by tkopp on 25.11.2016.
 */
public class TaskSettings {
    private JPanel panel1;
    private JLabel SubjectId;
    private JLabel FirstName;
    private JLabel LastName;
    private JLabel TaskId;
    private JLabel TaskName;
    private JTextField SubjectIdTextField;
    private JTextField FirstNameTextField;
    private JTextField LastNameTextField;
    private JTextField TaskIdTextField;
    private JTextField TaskNameTextField;
    private JButton TaskSettingsNext;

    private TaskSettings() {

        TaskSettingsNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Evaluation().main();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TaskSettings");
        frame.setContentPane(new TaskSettings().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
