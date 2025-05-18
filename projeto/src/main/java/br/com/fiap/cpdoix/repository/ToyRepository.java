package br.com.fiap.cpdoix.repository;

import br.com.fiap.cpdoix.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToyRepository extends JpaRepository<Toy, Long> {
}