import java.util.HashMap;

public class Months {
    HashMap<Integer,String> months;

    Months () {
        months = new HashMap<>();
        months.put(01, "Январь");
        months.put(02, "Февраль");
        months.put(03, "Март");
    }

    public HashMap<Integer, String> getMonths() {
        return months;
    }
}