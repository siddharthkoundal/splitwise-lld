package model.expense;

import model.User;
import model.split.EqualSplit;
import model.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(expensePaidBy, amount, splits, expenseData);
    }

    public boolean validate(){
        for(Split split: getSplits()){
            if(!(split instanceof EqualSplit)){
                return false;
            }
        }
        return true;
    }
}
