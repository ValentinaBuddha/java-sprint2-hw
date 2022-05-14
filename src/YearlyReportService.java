import java.util.HashMap;

public class YearlyReportService {
    ReadFile readFile = new ReadFile();
    HashMap<Integer, Double> yearlyReportExpense = new HashMap<>();
    HashMap<Integer, Double> yearlyReportRevenue = new HashMap<>();

    void readYearlyFile() {
        String yearlyFile = readFile.readFileContentOrNull
                ("C:/Users/Валентина/dev/java-sprint2-hw/resources/y.2021.csv");
        String[] lines = yearlyFile.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            if (lineContents[2].equals("false")) {
                yearlyReportRevenue.put(Integer.parseInt(lineContents[0]), Double.parseDouble(lineContents[1]));
            } else {
                yearlyReportExpense.put(Integer.parseInt(lineContents[0]), Double.parseDouble(lineContents[1]));
            }
        }
        System.out.println(yearlyReportRevenue);
        System.out.println(yearlyReportExpense);
    }
}
