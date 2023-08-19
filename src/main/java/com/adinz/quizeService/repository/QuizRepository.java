package com.adinz.quizeService.repository;

import com.adinz.quizeService.modal.Quize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quize, Integer> {
}
