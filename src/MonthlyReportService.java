import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportService {
    ReadFile readFile = new ReadFile();
    HashMap<Integer, ArrayList<MonthlyItemData>> monthsData = new HashMap<>();
    boolean monthlyReportsIsRead = false;
    Months months = new Months();
    HashMap<Integer, Double> monthRevenues = new HashMap<>();
    HashMap<Integer, Double> monthExpenses = new HashMap<>();
    HashMap<Integer, String> itemMaxRevenueInMonth = new HashMap<>();
    HashMap<Integer, Double> sumOfItemMaxRevenueInMonth = new HashMap<>();
    HashMap<Integer, String> itemMaxExpenseInMonth = new HashMap<>();
    HashMap<Integer, Double> SumOfItemMaxExpenseInMonth = new HashMap<>();

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
                                Double.parseDouble(itemData[3])));
            }
            monthsData.put(i + 1, monthlyItemsData);
        }
        monthlyReportsIsRead = true;
        System.out.println("Все месячные отчёты считаны.");
        System.out.println("---------------------------------");
    }

    void monthlyReportInfo() {
        if (monthlyReportsIsRead) {
            for (int i = 0; i < monthsData.size(); i++) {
                ArrayList<MonthlyItemData> monthData = monthsData.get(i + 1);
                double revenueItem = 0;
                double expenseItem = 0;
                double maxRevenue = 0;
                double maxExpense = 0;
                String itemMaxRevenue = "";
                String itemMaxExpense = "";
                for (int j = 0; j < monthData.size(); j++) {
                    if (!monthData.get(j).isExpense) {
                        revenueItem = monthData.get(j).quantity * monthData.get(j).sumOfOne;
                        if (revenueItem > maxRevenue) {
                            maxRevenue = revenueItem;
                            itemMaxRevenue = monthData.get(j).itemName;
                        }
                        itemMaxRevenueInMonth.put(i + 1, itemMaxRevenue);
                        sumOfItemMaxRevenueInMonth.put(i + 1, maxRevenue);
                    } else {
                        expenseItem = monthData.get(j).quantity * monthData.get(j).sumOfOne;
                        if (expenseItem > maxExpense) {
                            maxExpense = expenseItem;
                            itemMaxExpense = monthData.get(j).itemName;
                        }
                        itemMaxExpenseInMonth.put(i + 1, itemMaxExpense);
                        SumOfItemMaxExpenseInMonth.put(i + 1, maxExpense);
                    }
                }
                System.out.println("Данные за: " + months.getMonths().get(i + 1));
                System.out.println
                        ("Самый прибыльный товар: " + itemMaxRevenueInMonth.get(i) + " на сумму " + sumOfItemMaxRevenueInMonth.get(i));
                System.out.println
                        ("Самая большая трата: " + itemMaxExpenseInMonth.get(i) + " на сумму " + SumOfItemMaxExpenseInMonth.get(i));
                System.out.println("---------------------------------");
            }
        } else {
            System.out.println("Считайте месячные отчёты.");
        }
    }

    void commonNumberForReconciliation() {
        double commonMonthRevenue = 0;
        double commonMonthExpense = 0;
        double revenueItem = 0;
        double expenseItem = 0;
        for (int i = 0; i < monthsData.size(); i++) {
            ArrayList<MonthlyItemData> monthData = monthsData.get(i + 1);
            for (int j = 0; j < monthData.size(); j++) {
                if (!monthData.get(j).isExpense) {
                    revenueItem = monthData.get(j).quantity * monthData.get(j).sumOfOne;
                } else {
                    expenseItem = monthData.get(j).quantity * monthData.get(j).sumOfOne;
                }
                commonMonthRevenue += revenueItem;
                commonMonthExpense += expenseItem;
            }
            monthRevenues.put(i + 1, commonMonthRevenue);
            monthExpenses.put(i + 1, commonMonthExpense);
        }
    }
}