package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.IndependentProject;

@Repository
public interface IndependentProjectRepository extends JpaRepository<IndependentProject, Long> {

    Object findByProjectName(String projectName);
    // You can add custom query methods here if needed
}