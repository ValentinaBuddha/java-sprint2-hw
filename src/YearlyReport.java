public class YearlyReport {
    int year;
    int month;
    int amount;
    boolean is_expense;
    ReadFile readFile = new ReadFile();

    String yearlyFile = readFile.readFileContentOrNull("C:/Users/Валентина/dev/java-sprint2-hw/resources/y.2021.csv");

}
