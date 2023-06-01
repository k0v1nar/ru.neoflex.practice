package ru.neoflex.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.practice.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
