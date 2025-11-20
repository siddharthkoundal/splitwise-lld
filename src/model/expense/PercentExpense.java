package model.expense;

import model.User;
import model.split.PercentSplit;
import model.split.Split;

import java.util.List;

public class PercentExpense extends Expense{
    public PercentExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(expensePaidBy, amount, splits, expenseData);
    }

    public boolean validate(){
        double totalPercent = 100;
        double totalSplitPercent = 0;
        for(Split split: getSplits()){
            // Check if each split is of type PercentSplit
            if(!(split instanceof PercentSplit percentSplit)){
                return false;
            }
            totalSplitPercent += percentSplit.getPercent();
        }
        return totalSplitPercent == totalPercent;
    }
}
