import java.text.DecimalFormat;
import java.util.HashMap;

public class YearlyReportService {
    ReadFile readFile = new ReadFile();
    HashMap<Integer, Double> yearlyReportExpense = new HashMap<>();
    HashMap<Integer, Double> yearlyReportRevenue = new HashMap<>();
    double commonYearRevenue = 0;
    double commonYearExpense = 0;
    boolean yearlyReportIsRead = false;

    Months months = new Months();
    String yearPath = "C:/Users/Валентина/dev/java-sprint2-hw/resources/y.2021.csv";

    void readYearlyFile() {
        String yearlyFile = readFile.readFileContentOrNull(yearPath);
        String[] lines = yearlyFile.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            if (lineContents[2].equals("false")) {
                yearlyReportRevenue.put(Integer.parseInt(lineContents[0]), Double.parseDouble(lineContents[1]));
            } else {
                yearlyReportExpense.put(Integer.parseInt(lineContents[0]), Double.parseDouble(lineContents[1]));
            }
        }
        yearlyReportIsRead = true;
        System.out.println("Годовой отчёт считан.");
        System.out.println("---------------------------------");
    }

    void yearlyReportInfo() {
        if (yearlyReportIsRead) {
            String[] s1 = yearPath.split(".csv");
            char[] year = new char[4];
            s1[0].getChars(s1[0].length() - 4, s1[0].length(), year, 0);
            System.out.println("Данные за год: " + String.valueOf(year) + "\n---------------------------------");
            System.out.println("Прибыль за " + months.getMonths().get(01) + ":");
            System.out.println(yearlyReportRevenue.get(01) - yearlyReportExpense.get(01));
            System.out.println("Прибыль за " + months.getMonths().get(02) + ":");
            System.out.println(yearlyReportRevenue.get(02) - yearlyReportExpense.get(02));
            System.out.println("Прибыль за " + months.getMonths().get(03) + ":");
            System.out.println(yearlyReportRevenue.get(03) - yearlyReportExpense.get(03));
            for (Double revenue : yearlyReportRevenue.values()) {
                commonYearRevenue += revenue;
            }
            double averageRevenue = commonYearRevenue / months.getMonths().size();
            for (Double expense : yearlyReportExpense.values()) {
                commonYearExpense += expense;
            }
            double averageExpense = commonYearExpense / months.getMonths().size();
            DecimalFormat df = new DecimalFormat("########.##");
            System.out.println("Средний доход: " + df.format(averageRevenue));
            System.out.println("Средний расход: " + df.format(averageExpense));
            System.out.println("---------------------------------");
        } else {
            System.out.println("Считайте годовой отчёт.");
        }
    }
}