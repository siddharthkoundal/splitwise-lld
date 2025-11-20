package model.expense;

import model.User;
import model.split.ExactSplit;
import model.split.Split;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(expensePaidBy, amount, splits, expenseData);
    }

    public boolean validate(){
        double totalAmount = getAmount();
        double totalSplitAmount = 0;
        for(Split split: getSplits()){
            // Check if each split is of type ExactSplit
            if(!(split instanceof ExactSplit exactSplit)){
                return false;
            }
            totalSplitAmount += exactSplit.getAmount();
        }
        return totalAmount == totalSplitAmount;
    }
}
