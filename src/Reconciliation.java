public class Reconciliation {
    MonthlyReportService monthlyReportService = new MonthlyReportService();
    YearlyReportService yearlyReportService = new YearlyReportService();

   void reconciliation () {
       if (monthlyReportService.monthlyReportIsRead && yearlyReportService.yearlyReportIsRead) {
         /*
    общие доходы и расходы по месячным отчетам
    сравнить с годовыми цифрами.
    Если будет ошибка в сверке, выводить месяц с несоответствием.
    Если ошибок нет, то пишем успех.

     */
       } else {
           System.out.println("Считайте месячные и годовой отчёты.");
       }
   }
}