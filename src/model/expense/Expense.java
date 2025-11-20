package model.expense;

import model.User;
import model.split.Split;

import java.util.List;

public abstract class Expense {
    private final String id;
    private double amount;
    private User expensePaidBy;
    private List<Split> splits;
    private ExpenseData expenseData;

    public Expense(User expensePaidBy, double amount, List<Split> splits, ExpenseData expenseData){
        this.id = java.util.UUID.randomUUID().toString();
        this.amount = amount;
        this.expensePaidBy = expensePaidBy;
        this.splits = splits;
        this.expenseData = expenseData;
    }

    public String getId(){
        return id;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public User getExpensePaidBy() {
        return expensePaidBy;
    }

    public void setExpensePaidBy(User expensePaidBy) {
        this.expensePaidBy = expensePaidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public ExpenseData getExpenseData() {
        return expenseData;
    }

    public void setExpenseData(ExpenseData expenseData) {
        this.expenseData = expenseData;
    }

    public abstract boolean validate();
}
