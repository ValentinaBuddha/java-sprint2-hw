import java.util.ArrayList;
import java.util.HashMap;
import java.text.DecimalFormat;

public class ReportService {
    boolean monthlyReportsAreRead = false;
    boolean yearlyReportIsRead = false;
    double commonYearRevenue = 0;
    double commonYearExpense = 0;
    HashMap<Integer, ArrayList<MonthlyItemData>> monthsData = new HashMap<>();
    HashMap<Integer, Double> monthRevenues = new HashMap<>();
    HashMap<Integer, Double> monthExpenses = new HashMap<>();
    HashMap<Integer, String> itemMaxRevenueInMonth = new HashMap<>();
    HashMap<Integer, Double> sumOfItemMaxRevenueInMonth = new HashMap<>();
    HashMap<Integer, String> itemMaxExpenseInMonth = new HashMap<>();
    HashMap<Integer, Double> SumOfItemMaxExpenseInMonth = new HashMap<>();
    HashMap<Integer, Double> yearlyReportRevenue = new HashMap<>();
    HashMap<Integer, Double> yearlyReportExpense = new HashMap<>();
    Months months = new Months();
    DecimalFormat df = new DecimalFormat("########.##");
    String yearPath = "./resources/y.2021.csv";
    String monthPaths = "";

    public void readMonthlyFiles() {
        for (int i = 0; i < months.getMonths().size(); i++) {
            monthPaths = "./resources/m.20210";
            monthPaths += (i + 1) + ".csv";
            if (ReadFile.readFileContentOrNull(monthPaths) != null) {
                String file = ReadFile.readFileContentOrNull(monthPaths);
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
                ArrayList<MonthlyItemData> monthData = monthsData.get(i + 1);
                double revenueItem;
                double expenseItem;
                double maxRevenue = 0;
                double maxExpense = 0;
                String itemMaxRevenue = "";
                String itemMaxExpense = "";
                double commonMonthRevenue = 0;
                double commonMonthExpense = 0;
                for (MonthlyItemData monthDatum : monthData) {
                    if (!monthDatum.isExpense) {
                        revenueItem = monthDatum.quantity * monthDatum.sumOfOne;
                        if (revenueItem > maxRevenue) {
                            maxRevenue = revenueItem;
                            itemMaxRevenue = monthDatum.itemName;
                        }
                        commonMonthRevenue += revenueItem;
                        monthRevenues.put(i + 1, commonMonthRevenue);
                        itemMaxRevenueInMonth.put(i + 1, itemMaxRevenue);
                        sumOfItemMaxRevenueInMonth.put(i + 1, maxRevenue);
                    } else {
                        expenseItem = monthDatum.quantity * monthDatum.sumOfOne;
                        if (expenseItem > maxExpense) {
                            maxExpense = expenseItem;
                            itemMaxExpense = monthDatum.itemName;
                        }
                        commonMonthExpense += expenseItem;
                        monthExpenses.put(i + 1, commonMonthExpense);
                        itemMaxExpenseInMonth.put(i + 1, itemMaxExpense);
                        SumOfItemMaxExpenseInMonth.put(i + 1, maxExpense);
                    }
                }

                monthlyReportsAreRead = true;
                System.out.println("Отчёт за " + months.getMonths().get(i+1) + " считан.");
                System.out.println("---------------------------------");
            } else {
                System.out.println("Не удается найти файлы по указанному пути.");
            }
        }
    }


    public void monthlyReportInfo() {
        if (monthlyReportsAreRead) {
            for (int i = 0; i < monthsData.size(); i++) {
                System.out.println("Данные за: " + months.getMonths().get(i + 1));
                System.out.println("Самый прибыльный товар: " + itemMaxRevenueInMonth.get(i + 1) + " на сумму " + sumOfItemMaxRevenueInMonth.get(i + 1));
                System.out.println("Самая большая трата: " + itemMaxExpenseInMonth.get(i + 1) + " на сумму " + SumOfItemMaxExpenseInMonth.get(i + 1));
                System.out.println("---------------------------------");
            }
        } else {
            System.out.println("Считайте месячные отчёты.");
            System.out.println("---------------------------------");
        }
    }

    public void readYearlyFile() {
        if (ReadFile.readFileContentOrNull(yearPath) == null) {
            System.out.println("Не удается найти файл по указанному пути.");
        } else {
            String yearlyFile = ReadFile.readFileContentOrNull(yearPath);
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
    }

    public void yearlyReportInfo() {
        if (yearlyReportIsRead) {
            String[] s1 = yearPath.split(".csv");
            char[] year = new char[4];
            s1[0].getChars(s1[0].length() - 4, s1[0].length(), year, 0);
            System.out.println("Данные за год: " + String.valueOf(year));
            System.out.println("---------------------------------");
            for (int i = 1; i <= months.getMonths().size(); i++) {
                System.out.println("Прибыль за " + months.getMonths().get(i) + ":");
                System.out.println(yearlyReportRevenue.get(i) - yearlyReportExpense.get(i));
            }
            for (Double revenue : yearlyReportRevenue.values()) {
                commonYearRevenue += revenue;
            }
            double averageRevenue = commonYearRevenue / months.getMonths().size();
            for (Double expense : yearlyReportExpense.values()) {
                commonYearExpense += expense;
            }
            double averageExpense = commonYearExpense / months.getMonths().size();

            System.out.println("Средний доход: " + df.format(averageRevenue));
            System.out.println("Средний расход: " + df.format(averageExpense));
            System.out.println("---------------------------------");
        } else {
            System.out.println("Считайте годовой отчёт.");
            System.out.println("---------------------------------");
        }
    }

    public void reconciliation() {
        if (monthlyReportsAreRead && yearlyReportIsRead) {
            for (int i = 0; i < months.getMonths().size(); i++) {
                if (monthRevenues.get(i + 1).equals(yearlyReportRevenue.get(i + 1)) && monthExpenses.get(i + 1).equals(yearlyReportExpense.get(i + 1))) {
                    System.out.println("Сверка доходов и расходов за " + months.getMonths().get(i + 1) + " прошла успешно.");
                    System.out.println("---------------------------------");
                } else {
                    System.out.println("В ходе сверки доходов обнаружена ошибка. Проверьте отчёты за " + months.getMonths().get(i + 1));
                    System.out.println("---------------------------------");
                }
            }
        } else {
            System.out.println("Считайте все отчёты.");
            System.out.println("---------------------------------");
        }
    }
}
