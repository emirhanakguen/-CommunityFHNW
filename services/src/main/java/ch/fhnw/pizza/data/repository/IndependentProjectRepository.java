package services.src.main.java.ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.ch.fhnw.pizza.data.domain.IndependentProject;

@Repository
public interface IndependentProjectRepository extends JpaRepository<IndependentProject, Long> {
    // You can add custom query methods here if needed
}