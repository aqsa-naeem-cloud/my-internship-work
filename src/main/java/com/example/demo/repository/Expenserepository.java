
package com.example.demo.repository;

import com.example.demo.entity.expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Expenserepository extends JpaRepository<expense, Long> {

    List<expense> findByCategoryId(Long categoryId);

    @Query("SELECT COALESCE(SUM(e.amount), 0) FROM expense e")
    Double getTotalAmount();
}
