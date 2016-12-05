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

    public TaskSettings(Main MyMain) {
        Questionnaire CurrentQuestionnaire = MyMain.getCurrentQuestionnaire();
        JFrame frame = MyMain.getFrame();
        frame.setContentPane(this.panel1);
        frame.pack();
        frame.setVisible(true);

        // set saved text
        SubjectIdTextField.setText(CurrentQuestionnaire.getSubjectId());
        FirstNameTextField.setText(CurrentQuestionnaire.getFirstName());
        LastNameTextField.setText(CurrentQuestionnaire.getLastName());
        TaskIdTextField.setText(CurrentQuestionnaire.getTaskId());
        TaskNameTextField.setText(CurrentQuestionnaire.getTaskName());

        TaskSettingsNext.addActionListener(e -> {
            // save entered text
            CurrentQuestionnaire.setSubjectId(SubjectIdTextField.getText());
            CurrentQuestionnaire.setFirstName(FirstNameTextField.getText());
            CurrentQuestionnaire.setLastName(LastNameTextField.getText());
            CurrentQuestionnaire.setTaskId(TaskIdTextField.getText());
            CurrentQuestionnaire.setTaskName(TaskNameTextField.getText());

            MyMain.changeState(3);
        });
    }
}
