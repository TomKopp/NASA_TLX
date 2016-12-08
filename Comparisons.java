import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by marco on 25.11.2016.
 */
public class Comparisons {
    private JButton button1;
    private JButton button2;
    private JPanel comparisonPanel;
    private JButton nextButton;

    /*
    * 1= MD
    * 2= PD
    * 3= TD
    * 4= OP
    * 5= FR
    * 6= EF
     */
    private HashMap<Integer,String> numberTODemand;
    private ArrayList<String> leftList;
    private ArrayList<String> rightList;
    private HashMap<String, Integer> winnerMap;

    private int count = 1;
    private String pd = "PD";
    private String td = "TD";
    private String md = "MD";
    private String op = "OP";
    private String fr = "FR";
    private String ef = "EF";

    public Comparisons(Main MyMain) {
        Questionnaire CurrentQuestionnaire = MyMain.getCurrentQuestionnaire();
        JFrame frame = MyMain.getFrame();
        frame.setContentPane(this.comparisonPanel);
        frame.pack();
        frame.setVisible(true);

        this.numberTODemand = new HashMap<Integer,String>();
        this.leftList = new ArrayList<String>();
        this.rightList = new ArrayList<String>();
        this.winnerMap = new HashMap<String, Integer>();
        numberTODemand.put(1,md);
        numberTODemand.put(2,pd);
        numberTODemand.put(3,td);
        numberTODemand.put(4,op);
        numberTODemand.put(5,fr);
        numberTODemand.put(6,ef);

        leftList.add(pd);
        leftList.add(td);
        leftList.add(op);
        leftList.add(fr);
        leftList.add(ef);

        leftList.add(td);
        leftList.add(op);
        leftList.add(fr);
        leftList.add(ef);
        leftList.add(td);

        leftList.add(td);
        leftList.add(td);
        leftList.add(op);
        leftList.add(op);
        leftList.add(ef);

        rightList.add(md);
        rightList.add(md);
        rightList.add(md);
        rightList.add(md);
        rightList.add(md);

        rightList.add(pd);
        rightList.add(pd);
        rightList.add(pd);
        rightList.add(pd);
        rightList.add(op);

        rightList.add(fr);
        rightList.add(ef);
        rightList.add(fr);
        rightList.add(ef);
        rightList.add(fr);

        button1.setText(leftList.get(0));
        button2.setText(rightList.get(0));

       button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (count <=14) {

                    String clicked = button1.getText();
                    if (winnerMap.containsKey(clicked)){
                        winnerMap.put(clicked, winnerMap.get(clicked) + 1);
                    }
                    else{
                        winnerMap.put(clicked, 1);
                    }

                    button1.setText(leftList.get(count));
                    button2.setText(rightList.get(count));
                    count++;
                }
                }
            }
        );
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (count <=14) {
                    String clicked = button2.getText();
                    if (winnerMap.containsKey(clicked)){
                        winnerMap.put(clicked, winnerMap.get(clicked) + 1);
                    }
                    else{
                        winnerMap.put(clicked, 1);
                    }

                    button1.setText(leftList.get(count));
                    button2.setText(rightList.get(count));
                    count++;
                }
            }}
        );
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (count ==15){
                    for(String key : winnerMap.keySet()){
                        CurrentQuestionnaire.addWeight(key, winnerMap.get(key));
                    }
                    MyMain.changeState(3);
                }
            }
        });

    }
}
