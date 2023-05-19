package com.myapp.util;

import com.myapp.model.Destination;
import com.myapp.model.Expense;
import java.util.List;

public class OpenTripMapDataAnalyzer {
    private static final double MAX_EXPENSE_THRESHOLD = 100.0; // Maximum expense threshold in your desired currency

    public boolean isDestinationAffordable(Destination destination, List<Expense> expenses) {
        double totalExpense = calculateTotalExpense(expenses);
        return totalExpense <= MAX_EXPENSE_THRESHOLD;
    }

    private double calculateTotalExpense(List<Expense> expenses) {
        double totalExpense = 0.0;
        for (Expense expense : expenses) {
            totalExpense += expense.getCost();
        }
        return totalExpense;
    }
}