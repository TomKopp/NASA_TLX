import javax.swing.*;
import java.util.Vector;

/**
 * Created by witzbould on 02.12.2016.
 */
public class Main {

    private JFrame frame = new JFrame("NASA TLX");
    private Vector<Questionnaire> Questionnaires = new Vector<>(2);

    private Main() {
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (this.Questionnaires.isEmpty()) {
            this.Questionnaires.add(new Questionnaire());
        }

        changeState(0);
    }

    /**
     * 0, 1, 2 ... states for comparison, evaluation etc
     *
     * @param state
     */
    public void changeState(int state) {
        switch (state) {
            case 0:
                if (this.Questionnaires.lastElement().isFinalized()) {
                    this.Questionnaires.add(new Questionnaire());
                }

                new TaskSettings(this);
                break;
            case 1:
                new MainGUI(this);
                break;
            case 2:
                new Comparisons(this);
                break;
            case 3:
                new Evaluation(this);
                break;
            default:
                // do nothing
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    /* Getters */
    public JFrame getFrame() {
        return frame;
    }

    public Vector<Questionnaire> getQuestionnaires() {
        return Questionnaires;
    }

    public Questionnaire getCurrentQuestionnaire() {
        return Questionnaires.lastElement();
    }

}
