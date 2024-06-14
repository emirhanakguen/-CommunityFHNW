package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.JobAdvertisement;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Long> {

    Object findByTitle(String title);
    // You can add custom query methods here if needed
}