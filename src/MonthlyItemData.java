public class MonthlyItemData {
    String itemName;
    boolean isExpense;
    int quantity;
    double sumOfOne;

    MonthlyItemData (String itemName, boolean isExpense, int quantity, double sumOfOne){
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
