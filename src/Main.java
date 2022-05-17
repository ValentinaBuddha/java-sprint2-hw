import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportService reportService = new ReportService();
        int userInput = 0;

        while (userInput != 666) {
            printMenu();
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    reportService.readMonthlyFiles();
                    break;
                case 2:
                    reportService.readYearlyFile();
                    break;
                case 3:
                    reportService.reconciliation();
                    break;
                case 4:
                    reportService.monthlyReportInfo();
                    break;
                case 5:
                    reportService.yearlyReportInfo();
                    break;
                case 666:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("666 - Выход");
    }
}