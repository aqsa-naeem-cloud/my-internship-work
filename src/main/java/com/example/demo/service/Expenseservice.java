
package com.example.demo.service;
import com.example.demo.entity.catagory;
import com.example.demo.entity.expense;
import com.example.demo.repository.Catagoryrepository;
import com.example.demo.repository.Expenserepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class Expenseservice {

    private final Expenserepository expenserepository;
    private final Catagoryrepository catagoryrepository;

    public Expenseservice(Expenserepository expenserepository, Catagoryrepository catagoryrepository) {
        this.expenserepository = expenserepository;
        this.catagoryrepository = catagoryrepository;
    }

    public expense addExpense(String title, double amount, LocalDate date, Long categoryId) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        catagory cat = catagoryrepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        expense exp = new expense();
        exp.setTitle(title);
        exp.setAmount(amount);
        exp.setDate(date != null ? date : LocalDate.now());
        exp.setCategory(cat);

        return expenserepository.save(exp);
    }

    public List<expense> getAllExpenses() {
        return expenserepository.findAll();
    }

    public expense getExpenseById(Long id) {
        return expenserepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public expense updateExpense(Long id, String title, double amount, LocalDate date, Long categoryId) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        expense existing = getExpenseById(id);
        catagory cat = catagoryrepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setTitle(title);
        existing.setAmount(amount);
        existing.setDate(date);
        existing.setCategory(cat);

        return expenserepository.save(existing);
    }

    public void deleteExpense(Long id) {
        expenserepository.deleteById(id);
    }

    public List<expense> getExpensesByCategory(Long categoryId) {
        return expenserepository.findByCategoryId(categoryId);
    }

    public Double getTotalAmount() {
        return expenserepository.getTotalAmount();
    }
}
