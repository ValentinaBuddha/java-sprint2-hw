import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReportService {

    ReadFile readFile = new ReadFile();
    HashMap<Integer, ArrayList<MonthlyData>> monthData = new HashMap<>();
    ArrayList<MonthlyData> month1 = new ArrayList<>();
    ArrayList<MonthlyData> month2 = new ArrayList<>();
    ArrayList<MonthlyData> month3 = new ArrayList<>();

    void readMonthlyFiles() {
        ArrayList<String> filePaths = new ArrayList<>();
        filePaths.add("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202101.csv");
        filePaths.add("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202102.csv");
        filePaths.add("C:/Users/Валентина/dev/java-sprint2-hw/resources/m.202103.csv");
        for (int i = 0; i < 3; i++) {
            String file = readFile.readFileContentOrNull(filePaths.get(i));//считали файл - получилась одна большая строка
            String[] lines = file.split("\n"); //разбили строку на 7 строк - получился массив с 7ю ячейками
            for (int j = 1; j < lines.length; j++) { //цикл: строки со 2й разбиваем на 4 значения и складывааем в списки по месяцам
                String[] lineContents = lines[j].split(",");
                if (i == 0) {
                    month1.add(new MonthlyData(lineContents[0], Boolean.parseBoolean(lineContents[1]),
                            Integer.parseInt(lineContents[2]), Double.parseDouble(lineContents[3])));
                } else if (i == 1) {
                    month2.add(new MonthlyData(lineContents[0], Boolean.parseBoolean(lineContents[1]),
                            Integer.parseInt(lineContents[2]), Double.parseDouble(lineContents[3])));
                } else {
                    month3.add(new MonthlyData(lineContents[0], Boolean.parseBoolean(lineContents[1]),
                            Integer.parseInt(lineContents[2]), Double.parseDouble(lineContents[3])));
                }
            }
        }
        monthData.put(1, month1);
        monthData.put(2, month1);
        monthData.put(3, month1);
    }
}





