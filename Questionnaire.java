import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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


    public Boolean isFinalized() {
        return isFinalized;
    }

    public void setFinalize() {
        if (isFinalized) {
            return;
        }

        for (Object[] obj : Data) {
            obj[3] = (int) obj[1] * (int) obj[2];
            productSum += (int) obj[3];
            weightSum += (int) obj[2];
        }

        averageProduct = productSum / weightSum;
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

    public Object[][] getData() {
        return Data;
    }

    public void setData(Object[][] data) {
        this.Data = data;
    }

    public int getProductSum() {
        return productSum;
    }

    public int getWeightSum() {
        return weightSum;
    }

    public int getAverageProduct() {
        return averageProduct;
    }

    public void addWeight(String demand, Integer weight) {
        for (int i = 0; i <= 5; i++) {
            if (Data[i][0].equals(demand)) {
                Data[i][2] = weight;
            }
        }
    }

    public void addRating(String demand, Integer raiting) {
        for (int i = 0; i <= 5; i++) {
            if (Data[i][0].equals(demand)) {
                Data[i][1] = raiting;
            }
        }
    }

    public String getFilename() {
        return TaskId + "_" + SubjectId + "_results.csv";
    }

    public void csv_method() throws Exception {
        Path p3 = Paths.get(System.getProperty("user.dir"));
        String csvFile = p3.resolve(getFilename()).toString();
        FileWriter writer = new FileWriter(csvFile);

        CSVUtils.writeLine(writer, Arrays.asList("TaskID", "TaskName", "SubjectId", "LastName", "FirstName"));
        CSVUtils.writeLine(writer, Arrays.asList(getTaskId(), getTaskName(), getSubjectId(), getLastName(), getFirstName()));
        CSVUtils.writeLine(writer, Arrays.asList("Demands", "Rating", "Weight", "Product"));

        for (Object[] el : Data) {
            CSVUtils.writeLine(writer, Arrays.asList(
                    el[0].toString(),
                    el[1].toString(),
                    el[2].toString(),
                    el[3].toString()
            ));
        }

        CSVUtils.writeLine(writer, Arrays.asList("Sum", "Weight", "Product"));
        CSVUtils.writeLine(writer, Arrays.asList("" + productSum, "" + weightSum, "" + averageProduct));
        writer.flush();
        writer.close();
    }
}
