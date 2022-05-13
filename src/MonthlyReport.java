import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    int month;
    ReadFile readFile = new ReadFile();
    MonthlyInstance monthlyInstance1;
    MonthlyInstance monthlyInstance2;
    MonthlyInstance monthlyInstance3;
    HashMap<Integer, ArrayList<MonthlyInstance>> monthData = new HashMap<>();

    void reader() {
        String monthlyFile1 = readFile.readFileContentOrNull //считали файл - получилась одна большая строка
                ("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202101.csv");
        String[] lines = monthlyFile1.split("\n"); //разбили строку на 7 строк - получился массив с 7ю ячейками
        ArrayList<MonthlyInstance> month1 = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) { //цикл: строки со 2й разбиваем на 4 значения
            String[] lineContents = lines[i].split(",");
            month1.add(new MonthlyInstance(lineContents[0], Boolean.parseBoolean(lineContents[1]),
                    Integer.parseInt(lineContents[2]), Integer.parseInt(lineContents[3])));

        }
        for (MonthlyInstance m1 : month1) {
            System.out.println(m1.itemName);
        }

    }

    String monthlyFile2 = readFile.readFileContentOrNull
            ("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202102.csv");
    String monthlyFile3 = readFile.readFileContentOrNull
            ("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202103.csv");

}
