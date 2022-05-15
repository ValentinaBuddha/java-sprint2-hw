import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportService {

    ReadFile readFile = new ReadFile();
    HashMap<Integer, ArrayList<MonthlyItemData>> monthsData = new HashMap<>();
    ArrayList<MonthlyItemData> month1 = new ArrayList<>();
    ArrayList<MonthlyItemData> month2 = new ArrayList<>();
    ArrayList<MonthlyItemData> month3 = new ArrayList<>();
    boolean monthlyReportIsRead = false;
    Months months = new Months();

    void readMonthlyFiles() {
        ArrayList<String> filePaths = new ArrayList<>();
        filePaths.add("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202101.csv");
        filePaths.add("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202102.csv");
        filePaths.add("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202103.csv");
        for (int i = 0; i < months.getMonths().size(); i++) {
            String file = readFile.readFileContentOrNull(filePaths.get(i));
            String[] lines = file.split("\n");
            ArrayList<MonthlyItemData> monthlyItemsData = new ArrayList<>();
            for (int j = 1; j < lines.length; j++) {
                String[] itemData = lines[j].split(",");
                monthlyItemsData.add(
                        new MonthlyItemData(itemData[0],
                                Boolean.parseBoolean(itemData[1]),
                                Integer.parseInt(itemData[2]),
                                Double.parseDouble(itemData[3]))
                );
            }
            int monthNumber = i+1;
            monthsData.put(monthNumber, monthlyItemsData);
        }
        monthlyReportIsRead = true;
        System.out.println("Все месячные отчёты считаны.");
        System.out.println("---------------------------------");
    }

    void monthlyReportInfo() {
        if (monthlyReportIsRead) {
            /*
            1. название месяца
            2. самый прибыльный товар
            isExpense = false, кол * сумма max
            Вывести название товара и сумму
            3. max трата
             */
        } else {
            System.out.println("Считайте месячные отчёты.");
        }
    }

    //общие доходы и расходы для сверки
}





