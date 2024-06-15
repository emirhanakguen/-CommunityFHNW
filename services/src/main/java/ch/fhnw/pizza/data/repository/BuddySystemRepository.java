package ch.fhnw.pizza.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.BuddySystem;

@Repository
public interface BuddySystemRepository extends JpaRepository<BuddySystem, Long> {
    List<BuddySystem> findByLanguage(String language);
    // You can add custom query methods here if needed

    List<BuddySystem> findByLanguages(String languages);
    @SuppressWarnings({ "null", "unchecked" })
    BuddySystem save(BuddySystem buddySystem);
}