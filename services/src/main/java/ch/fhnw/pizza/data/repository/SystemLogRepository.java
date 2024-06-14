package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.SystemLog;

@Repository
public interface SystemLogRepository extends JpaRepository<SystemLog, Long> {
    // You can add custom query methods here if needed
}