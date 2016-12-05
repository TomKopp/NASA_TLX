import javax.swing.*;
import java.util.Vector;

/**
 * Created by witzbould on 02.12.2016.
 */
public class Main {

    private JFrame frame = new JFrame("NASA TLX");
    private Vector<Questionnaire> Questionnaires = new Vector<Questionnaire>(2);

    private Main() {
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (this.Questionnaires.isEmpty()) {
            this.Questionnaires.add(new Questionnaire());
        }

        changeState(3);
    }

    /**
     * 0, 1, 2 ... states for comparison, evaluation etc
     * 10, 11, ... states for MD-PD, PD-TD, TD-OP comparisons
     * 100 ... state for program control (loading/save files, exiting program...)
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
            case 3:
                new Comparisons(this);
                break;
            case 4:
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

    public Vector getQuestionnaires() {
        return Questionnaires;
    }

    public Questionnaire getCurrentQuestionnaire() {
        return Questionnaires.lastElement();
    }

}
