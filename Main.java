import javax.swing.*;

/**
 * Created by witzbould on 02.12.2016.
 */
public class Main {

    private JFrame frame;

    private Main() {
        this.frame = new JFrame("NASA TLX");

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.frame.pack();
//        this.frame.setVisible(true);

        changeState(0);
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
                new TaskSettings(this);
                break;
            case 4:
                new Evaluation(this);
                break;
            default:
                // do nothing
        }
    }

    public static void main(String[] args) {
        Main blubber = new Main();
    }

    /* Getters */
    public JFrame getFrame() {
        return frame;
    }

    /* Setters */

}
