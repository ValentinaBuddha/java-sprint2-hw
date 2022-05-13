import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    int month;
    ReadFile readFile = new ReadFile();
    MonthlyInstance monthlyInstance1 = new MonthlyInstance();
    MonthlyInstance monthlyInstance2 = new MonthlyInstance();
    MonthlyInstance monthlyInstance3 = new MonthlyInstance();
    HashMap<Integer, ArrayList<MonthlyInstance>> monthData = new HashMap<>();

void reader () {
    String monthlyFile1 = readFile.readFileContentOrNull //считали файл - получилась одна большая строка
            ("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202101.csv");
    String[] lines = monthlyFile1.split("\n"); //разбили строку на 7 строк - получился массив с 7ю ячейками
    for (int i = 1; i < lines.length; i++) { //цикл: строки со 2й разбиваем на 4 значения
        String[] lineContents = lines[i].split(",");
        monthlyInstance1.itemName = lineContents[0];
        monthlyInstance1.isExpense = Boolean.parseBoolean(lineContents[1]);
        monthlyInstance1.quantity = Integer.parseInt(lineContents[2]);
        monthlyInstance1.sumOfOne = Integer.parseInt(lineContents[3]);
        ArrayList<MonthlyInstance>

    }
    }

    String monthlyFile2 = readFile.readFileContentOrNull
            ("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202102.csv");
    String monthlyFile3 = readFile.readFileContentOrNull
            ("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202103.csv");



}
