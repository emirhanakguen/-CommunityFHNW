package ch.fhnw.pizza.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.pizza.data.domain.AccountManagement;
import ch.fhnw.pizza.data.domain.AccountManagement.Actiontype;

@Repository
public interface AccountManagementRepository extends JpaRepository<AccountManagement, Long> {

    Object findByActionType(Actiontype actionType);
    // You can add custom query methods here if needed
}