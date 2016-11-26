import com.sun.javafx.collections.MappingChange;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


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
    private HashMap<HashMap<Integer,Integer>, Integer> comparisonMap;
    private int count = 1;
    private String pd = "PD";
    private String td = "TD";
    private String md = "MD";
    private String op = "OP";
    private String fr = "FR";
    private String ef = "EF";

    public Comparisons() {
        this.numberTODemand = new HashMap<Integer,String>();
        this.comparisonMap = new HashMap<HashMap<Integer,Integer>, Integer>();
        this.leftList = new ArrayList<String>();
        this.rightList = new ArrayList<String>();
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
                    int clicked = getKey(button1.getText(), numberTODemand);
                    int unclicked = getKey(button2.getText(), numberTODemand);
                    HashMap<Integer, Integer> components = new HashMap<Integer, Integer>();
                    components.put(clicked, unclicked);
                    comparisonMap.put(components, clicked);

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
                    int clicked = getKey(button2.getText(), numberTODemand);
                    int unclicked = getKey(button1.getText(), numberTODemand);
                    HashMap<Integer, Integer> components = new HashMap<Integer, Integer>();
                    components.put(clicked, unclicked);
                    comparisonMap.put(components, clicked);

                    button1.setText(leftList.get(count));
                    button2.setText(rightList.get(count));
                    count++;
                }
            }}
        );
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (count ==14){
                }
            }
        });

    }

    public HashMap<HashMap<Integer,Integer>, Integer> getResults(){
        return this.comparisonMap;
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Comparisons");
        frame.setContentPane(new Comparisons().comparisonPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public Integer getKey(String value, HashMap<Integer, String> map){
        for(Integer key : map.keySet()){
            if(map.get(key).equals(value)){
                return key; //return the first found
            }
        }
        return null;
    }
    /*public String getKey(String value, HashMap<String, String> map){
        for(String key : map.keySet()){
            if(map.get(key).equals(value)){
                return key; //return the first found
            }
        }
        return null;
    }*/

}
