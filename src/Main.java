import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    monthlyReport.reader();
                    break;
                case 2:
                    System.out.println("2 - Считать годовой отчёт");
                    break;
                case 3:
                    System.out.println("3 - Сверить отчёты");
                    break;
                case 4:
                    System.out.println("4 - Вывести информацию о всех месячных отчётах");
                    break;
                case 5:
                    System.out.println("5 - Вывести информацию о годовом отчёте");
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