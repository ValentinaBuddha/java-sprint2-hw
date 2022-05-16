public class Reconciliation {
    MonthlyReportService monthlyReportService = new MonthlyReportService();
    YearlyReportService yearlyReportService = new YearlyReportService();
    Months months = new Months();

    void reconciliation() {
        if (monthlyReportService.monthlyReportsIsRead && yearlyReportService.yearlyReportIsRead) {
            for (int i = 0; i < months.getMonths().size(); i++) {
                if (monthlyReportService.monthRevenues.get(i) == yearlyReportService.yearlyReportRevenue.get(i)) {
                    System.out.println("Сверка годового и месячных отчётов прошла успешно.");
                } else {
                    System.out.println("Обнаружена ошибка. Проверьте отчёты за " + months.getMonths().get(i));
                }
            }
        } else {
            System.out.println("Считайте месячные и годовой отчёты.");
        }
    }
}