import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MonthlyReportService monthlyReportService = new MonthlyReportService();
        YearlyReportService yearlyReportService = new YearlyReportService();
        int userInput = 0;

        while (userInput != 666) {
            printMenu();
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    monthlyReportService.readMonthlyFiles();
                    break;
                case 2:
                    yearlyReportService.readYearlyFile();
                    break;
                case 3:

                    break;
                case 4:
                    monthlyReportService.monthlyReportInfo();
                    break;
                case 5:
                    yearlyReportService.yearlyReportInfo();
                    break;
                case 666:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("666 - Выход");
    }
}