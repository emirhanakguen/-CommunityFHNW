package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.MentoringForProjects;

@Repository
public interface MentoringForProjectsRepository extends JpaRepository<MentoringForProjects, Long> {

    Object findBySubject(String subject);
    // You can add custom query methods here if needed
}