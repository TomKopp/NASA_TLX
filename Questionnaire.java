import java.io.FileWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.net.URI;
import java.nio.file.*;

/**
 * Created by witzb on 04.12.2016.
 */
public class Questionnaire {
    private Boolean isFinalized = false;
    private String SubjectId = "";
    private String FirstName = "";
    private String LastName = "";
    private String TaskId = "";
    private String TaskName = "";
    private float sum = 0;
    private float weights = 0;
    private float avg = 0;
    private Object[][] Data = {
            {"MD", 50, 0, null},
            {"PD", 50, 0, null},
            {"TD", 50, 0, null},
            {"OP", 50, 0, null},
            {"FR", 50, 0, null},
            {"EF", 50, 0, null}
    };
    private int productSum = 0;
    private int weightSum = 0;
    private int averageProduct;
//    private String [][] Data = {
//            {"MD","","",""},
//            {"PD","","",""},
//            {"TD","","",""},
//            {"OP","","",""},
//            {"FR","","",""},
//            {"EF","","",""},
//    };


    public Boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalize() {
        if (isFinalized) {
            return;
        }

        for (Object[] obj : Data) {
            obj[3] = (int) obj[1] * (int) obj[2];
            sum += (int) obj[3];
            weights += (int) obj[2];
        }

        avg = sum / weights;
        isFinalized = true;
    }

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String subjectId) {
        SubjectId = subjectId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public float getWeights() {
        return weights;
    }

    public void setWeights(float weights) {
        this.weights = weights;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public Object[][] getData() {
        return Data;
    }

    public void setData(Object[][] data) {
        this.Data = data;
    }

    public void addWeight(String demand, Integer weight) {
        int laNull = 0;
        for (int i = 0; i <= 5; i++) {
            if (Data[i][0].equals(demand)) {
                Data[i][2] = weight.toString();
                weightSum += weight;
            }
            //Auffüllen der Tabelle mit 0 String
            if (Data[i][2] == "") {
                Data[i][2] = "" + 0;
            }
        }
        calculateProduct((String[][]) getData());
        calculateAverageProduct();
    }

    public void addRating(String demand, Integer raiting) {
        for (int i = 0; i <= 5; i++) {
            if (Data[i][0].equals(demand)) {
                Data[i][1] = raiting.toString();
            }
            //Auffüllen der Tabelle mit 0 String
            if (Data[i][1] == "") {
                Data[i][1] = "" + 0;
            }
        }
    }

    public void csv_method() throws Exception {
        Path p3 = Paths.get(URI.create("file:///Users/marco/Desktop/" + TaskId + "_" + SubjectId + "_results.csv"));
        String csvFile = p3.toString();
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, Arrays.asList("TaskID", "TaskName", "SubjectId", "LastName", "FirstName"));
        CSVUtils.writeLine(writer, Arrays.asList(getTaskId(), getTaskName(), getSubjectId(), getLastName(), getFirstName()));
        CSVUtils.writeLine(writer, Arrays.asList("Demands", "Rating", "Weight", "Product"));
        for (int i = 0; i <= 5; i++) {
            CSVUtils.writeLine(writer, Arrays.asList((String[]) Data[i]));
        }
        CSVUtils.writeLine(writer, Arrays.asList("Sum", "Weight", "Product"));
        CSVUtils.writeLine(writer, Arrays.asList("" + productSum, "" + weightSum, "" + averageProduct));
        writer.flush();
        writer.close();
    }

    public void calculateProduct(String[][] data) {
        for (int i = 0; i <= 5; i++) {
            int zahl1 = Integer.parseInt(data[i][1]);
            int zahl2 = Integer.parseInt(data[i][2]);
            int ergebnis = zahl1 * zahl2;
            String ergebnisString = "" + ergebnis;
            data[i][3] = ergebnisString;
            productSum += ergebnis;
        }
    }

    public void calculateAverageProduct() {
        averageProduct = productSum / weightSum;
    }


}
