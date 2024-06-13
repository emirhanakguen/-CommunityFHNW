package services.src.main.java.ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import services.src.main.java.ch.fhnw.pizza.data.domain.BuddySystem;

@Repository
public interface BuddySystemRepository extends JpaRepository<BuddySystem, Long> {
    List<BuddySystem> findByLanguage(String language);
    // You can add custom query methods here if needed
}