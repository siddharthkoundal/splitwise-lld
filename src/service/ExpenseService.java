package service;

import model.ExpenseType;
import model.User;
import model.expense.*;
import model.split.PercentSplit;
import model.split.Split;

import java.util.List;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount, User expensePadiBy,
                                        List<Split> splits, ExpenseData expenseData){
        switch (expenseType){
            case EQUAL:
                int totalSplits = splits.size();
                double equalShare = Math.round((amount / totalSplits) * 100.0) / 100.0;
                for(Split split: splits){
                    split.setAmount(equalShare);
                }
                return new EqualExpense(amount, expensePadiBy, splits, expenseData);
            case EXACT:
                return new ExactExpense(amount, expensePadiBy, splits, expenseData);
            case PERCENT:
                for(Split split: splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount((amount * percentSplit.getPercent()) / 100);
                }
                return new PercentExpense(amount, expensePadiBy, splits, expenseData);
            default:
                return null;
        }
    }
}
