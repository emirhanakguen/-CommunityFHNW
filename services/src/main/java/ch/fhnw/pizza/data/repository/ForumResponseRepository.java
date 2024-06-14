package ch.fhnw.pizza.data.repository;

import java.security.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.ForumResponse;

@Repository
public interface ForumResponseRepository extends JpaRepository<ForumResponse, Long> {

    Object findByResponseTime(Timestamp responseTime);
    // You can add custom query methods here if needed
}
