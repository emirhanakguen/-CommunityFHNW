package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.ForumResponse;

@Repository
public interface ForumResponseRepository extends JpaRepository<ForumResponse, Long> {

    Object findByResponseTime(String string);
    // You can add custom query methods here if needed
}
