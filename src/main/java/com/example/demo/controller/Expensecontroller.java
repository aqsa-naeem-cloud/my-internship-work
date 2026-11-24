
package com.example.demo.controller;

import com.example.demo.entity.expense;
import com.example.demo.service.Expenseservice;
import org.springframework.web.bind.annotation.*;
        import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class Expensecontroller {

    private final Expenseservice expenseservice;

    public Expensecontroller(Expenseservice expenseservice) {
        this.expenseservice = expenseservice;
    }

    public static class ExpenseRequest {
        public String title;
        public double amount;
        public LocalDate date;
        public Long categoryId;
    }

    @PostMapping
    public expense addExpense(@RequestBody ExpenseRequest req) {
        return expenseservice.addExpense(req.title, req.amount, req.date, req.categoryId);
    }

    @GetMapping
    public List<expense> getAllExpenses() {
        return expenseservice.getAllExpenses();
    }

    @GetMapping("/{id}")
    public expense getExpenseById(@PathVariable Long id) {
        return expenseservice.getExpenseById(id);
    }

    @PutMapping("/{id}")
    public expense updateExpense(@PathVariable Long id, @RequestBody ExpenseRequest req) {
        return expenseservice.updateExpense(id, req.title, req.amount, req.date, req.categoryId);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseservice.deleteExpense(id);
        return "Expense deleted successfully";
    }

    @GetMapping("/category/{categoryId}")
    public List<expense> getExpensesByCategory(@PathVariable Long categoryId) {
        return expenseservice.getExpensesByCategory(categoryId);
    }

    @GetMapping("/total")
    public Double getTotalAmount() {
        return expenseservice.getTotalAmount();
    }
}
